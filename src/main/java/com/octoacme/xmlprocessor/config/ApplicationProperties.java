package com.octoacme.xmlprocessor.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Typed configuration properties for the XML processor application.
 */
@Configuration
@ConfigurationProperties(prefix = "app.amqp")
public class ApplicationProperties {

    private String exchange = "xml-processor-exchange";
    private String inputQueue = "xml.input";
    private String returnQueue = "xml.return";
    private String outputQueue = "xml.output";

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getInputQueue() {
        return inputQueue;
    }

    public void setInputQueue(String inputQueue) {
        this.inputQueue = inputQueue;
    }

    public String getReturnQueue() {
        return returnQueue;
    }

    public void setReturnQueue(String returnQueue) {
        this.returnQueue = returnQueue;
    }

    public String getOutputQueue() {
        return outputQueue;
    }

    public void setOutputQueue(String outputQueue) {
        this.outputQueue = outputQueue;
    }
}
