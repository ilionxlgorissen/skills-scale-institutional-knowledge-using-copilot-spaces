package com.octoacme.xmlprocessor.handler;

import com.octoacme.xmlprocessor.model.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Sends ACK and NACK responses to the AMQP return queue.
 */
@Component
public class ResponseHandler {

    private static final Logger log = LoggerFactory.getLogger(ResponseHandler.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.amqp.exchange:xml-processor-exchange}")
    private String exchange;

    @Value("${app.amqp.return-queue:xml.return}")
    private String returnQueue;

    public ResponseHandler(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Sends an ACK response for the given message.
     *
     * @param messageId     original message identifier
     * @param correlationId correlation identifier
     */
    public void sendAck(String messageId, String correlationId) {
        MessageResponse response = MessageResponse.ack(messageId, correlationId);
        log.debug("Sending ACK for messageId={}", messageId);
        rabbitTemplate.convertAndSend(exchange, returnQueue, response);
    }

    /**
     * Sends a NACK response for the given message.
     *
     * @param messageId       original message identifier
     * @param correlationId   correlation identifier
     * @param reason          human-readable reason for rejection
     */
    public void sendNack(String messageId, String correlationId, String reason) {
        MessageResponse response = MessageResponse.nack(messageId, correlationId, reason);
        log.debug("Sending NACK for messageId={} reason={}", messageId, reason);
        rabbitTemplate.convertAndSend(exchange, returnQueue, response);
    }
}
