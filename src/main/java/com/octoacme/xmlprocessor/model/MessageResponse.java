package com.octoacme.xmlprocessor.model;

/**
 * Represents the ACK/NACK response sent back on the return queue.
 */
public class MessageResponse {

    private String messageId;
    private String correlationId;
    private ResponseStatus status;
    private String reason;

    public MessageResponse() {
    }

    public MessageResponse(String messageId, String correlationId, ResponseStatus status, String reason) {
        this.messageId = messageId;
        this.correlationId = correlationId;
        this.status = status;
        this.reason = reason;
    }

    public static MessageResponse ack(String messageId, String correlationId) {
        return new MessageResponse(messageId, correlationId, ResponseStatus.ACK, null);
    }

    public static MessageResponse nack(String messageId, String correlationId, String reason) {
        return new MessageResponse(messageId, correlationId, ResponseStatus.NACK, reason);
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

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "MessageResponse{messageId='" + messageId + "', status=" + status + ", reason='" + reason + "'}";
    }
}
