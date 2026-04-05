package com.octoacme.xmlprocessor.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Forwards validated XML payloads to the AMQP output queue.
 */
@Component
public class OutputHandler {

    private static final Logger log = LoggerFactory.getLogger(OutputHandler.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.amqp.exchange:xml-processor-exchange}")
    private String exchange;

    @Value("${app.amqp.output-queue:xml.output}")
    private String outputQueue;

    public OutputHandler(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Sends the validated XML payload to the output queue.
     *
     * @param xmlPayload the well-formed XML string to forward
     */
    public void forward(String xmlPayload) {
        log.debug("Forwarding XML payload to output queue '{}'", outputQueue);
        rabbitTemplate.convertAndSend(exchange, outputQueue, xmlPayload);
    }
}
