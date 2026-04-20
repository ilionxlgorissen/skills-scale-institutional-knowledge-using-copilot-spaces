package com.octoacme.xmlprocessor.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AMQP (RabbitMQ) configuration for the XML processor.
 *
 * <p>Declares three durable queues bound to a direct exchange:
 * <ul>
 *   <li><b>input queue</b>  – receives JSON-enveloped XML messages</li>
 *   <li><b>return queue</b> – receives ACK / NACK responses</li>
 *   <li><b>output queue</b> – receives validated XML messages forwarded by the output handler</li>
 * </ul>
 */
@Configuration
public class AmqpConfig {

    @Value("${app.amqp.exchange:xml-processor-exchange}")
    private String exchangeName;

    @Value("${app.amqp.input-queue:xml.input}")
    private String inputQueueName;

    @Value("${app.amqp.return-queue:xml.return}")
    private String returnQueueName;

    @Value("${app.amqp.output-queue:xml.output}")
    private String outputQueueName;

    /* ------------------------------------------------------------------ */
    /* Exchange                                                             */
    /* ------------------------------------------------------------------ */

    @Bean
    public DirectExchange xmlProcessorExchange() {
        return new DirectExchange(exchangeName, true, false);
    }

    /* ------------------------------------------------------------------ */
    /* Queues                                                               */
    /* ------------------------------------------------------------------ */

    @Bean
    public Queue inputQueue() {
        return QueueBuilder.durable(inputQueueName).build();
    }

    @Bean
    public Queue returnQueue() {
        return QueueBuilder.durable(returnQueueName).build();
    }

    @Bean
    public Queue outputQueue() {
        return QueueBuilder.durable(outputQueueName).build();
    }

    /* ------------------------------------------------------------------ */
    /* Bindings                                                             */
    /* ------------------------------------------------------------------ */

    @Bean
    public Binding inputQueueBinding() {
        return BindingBuilder.bind(inputQueue()).to(xmlProcessorExchange()).with(inputQueueName);
    }

    @Bean
    public Binding returnQueueBinding() {
        return BindingBuilder.bind(returnQueue()).to(xmlProcessorExchange()).with(returnQueueName);
    }

    @Bean
    public Binding outputQueueBinding() {
        return BindingBuilder.bind(outputQueue()).to(xmlProcessorExchange()).with(outputQueueName);
    }

    /* ------------------------------------------------------------------ */
    /* Message converter & template                                         */
    /* ------------------------------------------------------------------ */

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}
