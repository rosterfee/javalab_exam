package ru.itis.javalab.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("pdf_gen_exchange");
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
