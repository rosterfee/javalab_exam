package ru.itis.javalab.pdfgenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PdfGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdfGeneratorApplication.class, args);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("pdf_gen_exchange");
    }

    @Bean
    public Queue dismissalQueue() {
        return new Queue("dismissal");
    }

    @Bean
    public Queue vacationQueue() {
        return new Queue("vacation");
    }

    @Bean
    public Binding dismissalBinding(DirectExchange directExchange, Queue dismissalQueue) {
        return BindingBuilder.bind(dismissalQueue).to(directExchange)
                .with("dismissal");
    }

    @Bean
    public Binding vacationBuilding(DirectExchange directExchange, Queue vacationQueue) {
        return BindingBuilder.bind(vacationQueue).to(directExchange).with("vacation");
    }

    @Bean
    public RabbitListenerContainerFactory<SimpleMessageListenerContainer> containerFactory(
            ConnectionFactory connectionFactory) {

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setPrefetchCount(10);
        factory.setConcurrentConsumers(5);
        factory.setReceiveTimeout(1000L);

        return factory;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
