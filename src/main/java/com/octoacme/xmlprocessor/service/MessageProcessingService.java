package com.octoacme.xmlprocessor.service;

import com.octoacme.xmlprocessor.entity.MessageLog;
import com.octoacme.xmlprocessor.handler.OutputHandler;
import com.octoacme.xmlprocessor.handler.ResponseHandler;
import com.octoacme.xmlprocessor.model.MessageEnvelope;
import com.octoacme.xmlprocessor.model.MessageResponse;
import com.octoacme.xmlprocessor.model.ResponseStatus;
import com.octoacme.xmlprocessor.repository.MessageLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * Orchestrates the full processing lifecycle for a single {@link MessageEnvelope}:
 * <ol>
 *   <li>Validate the embedded XML payload.</li>
 *   <li>Persist an audit record to the database.</li>
 *   <li>Send ACK or NACK to the return queue.</li>
 *   <li>When valid, forward the XML to the output handler.</li>
 * </ol>
 */
@Service
public class MessageProcessingService {

    private static final Logger log = LoggerFactory.getLogger(MessageProcessingService.class);

    private final XmlValidationService xmlValidationService;
    private final ResponseHandler responseHandler;
    private final OutputHandler outputHandler;
    private final MessageLogRepository messageLogRepository;

    public MessageProcessingService(XmlValidationService xmlValidationService,
                                    ResponseHandler responseHandler,
                                    OutputHandler outputHandler,
                                    MessageLogRepository messageLogRepository) {
        this.xmlValidationService = xmlValidationService;
        this.responseHandler = responseHandler;
        this.outputHandler = outputHandler;
        this.messageLogRepository = messageLogRepository;
    }

    /**
     * Processes the incoming envelope.
     *
     * @param envelope the JSON envelope containing the XML payload
     */
    public void process(MessageEnvelope envelope) {
        log.info("Processing message: {}", envelope.getMessageId());

        boolean valid = xmlValidationService.isValid(envelope.getXmlPayload());
        String validationError = valid ? null : xmlValidationService.getValidationError(envelope.getXmlPayload());

        // Persist audit record
        MessageLog logEntry = new MessageLog();
        logEntry.setMessageId(envelope.getMessageId());
        logEntry.setCorrelationId(envelope.getCorrelationId());
        logEntry.setStatus(valid ? ResponseStatus.ACK : ResponseStatus.NACK);
        logEntry.setValidationError(validationError);
        logEntry.setReceivedAt(Instant.now());
        messageLogRepository.save(logEntry);

        if (valid) {
            log.info("Message {} is valid – sending ACK and forwarding to output", envelope.getMessageId());
            responseHandler.sendAck(envelope.getMessageId(), envelope.getCorrelationId());
            outputHandler.forward(envelope.getXmlPayload());
        } else {
            log.warn("Message {} failed validation: {} – sending NACK", envelope.getMessageId(), validationError);
            responseHandler.sendNack(envelope.getMessageId(), envelope.getCorrelationId(), validationError);
        }
    }
}
