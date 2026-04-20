package com.octoacme.xmlprocessor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

/**
 * JSON envelope that wraps an XML message received on the input AMQP queue.
 *
 * <p>Example payload:
 * <pre>
 * {
 *   "messageId": "abc-123",
 *   "correlationId": "corr-456",
 *   "xmlPayload": "&lt;root&gt;&lt;data&gt;value&lt;/data&gt;&lt;/root&gt;"
 * }
 * </pre>
 */
public class MessageEnvelope {

    @NotBlank(message = "messageId must not be blank")
    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("correlationId")
    private String correlationId;

    @NotBlank(message = "xmlPayload must not be blank")
    @JsonProperty("xmlPayload")
    private String xmlPayload;

    public MessageEnvelope() {
    }

    public MessageEnvelope(String messageId, String correlationId, String xmlPayload) {
        this.messageId = messageId;
        this.correlationId = correlationId;
        this.xmlPayload = xmlPayload;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getXmlPayload() {
        return xmlPayload;
    }

    public void setXmlPayload(String xmlPayload) {
        this.xmlPayload = xmlPayload;
    }

    @Override
    public String toString() {
        return "MessageEnvelope{messageId='" + messageId + "', correlationId='" + correlationId + "'}";
    }
}
