package com.octoacme.xmlprocessor.listener;

import com.octoacme.xmlprocessor.model.MessageEnvelope;
import com.octoacme.xmlprocessor.service.MessageProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * AMQP listener that consumes JSON-enveloped XML messages from the input queue.
 *
 * <p>Spring AMQP automatically deserialises the incoming JSON body into a
 * {@link MessageEnvelope} via the configured {@link com.fasterxml.jackson.databind.ObjectMapper}.
 * Each successfully delivered message is delegated to {@link MessageProcessingService}
 * for validation and routing.
 */
@Component
public class InputQueueListener {

    private static final Logger log = LoggerFactory.getLogger(InputQueueListener.class);

    private final MessageProcessingService messageProcessingService;

    public InputQueueListener(MessageProcessingService messageProcessingService) {
        this.messageProcessingService = messageProcessingService;
    }

    /**
     * Handles a single message from the input queue.
     *
     * @param envelope the deserialised JSON envelope containing the XML payload
     */
    @RabbitListener(queues = "${app.amqp.input-queue:xml.input}")
    public void onMessage(MessageEnvelope envelope) {
        log.info("Received message from input queue: {}", envelope);
        try {
            messageProcessingService.process(envelope);
        } catch (Exception e) {
            log.error("Unexpected error while processing message {}: {}",
                    envelope.getMessageId(), e.getMessage(), e);
            // Re-throwing will cause Spring AMQP to NACK the message and
            // move it to the DLQ (if configured), preventing silent message loss.
            throw e;
        }
    }
}
