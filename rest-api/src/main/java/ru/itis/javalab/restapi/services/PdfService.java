package ru.itis.javalab.restapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.restapi.entities.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Киямдинов Ильдар
 * @project app
 * @created 06.01.2022
 */

@Service
public class PdfService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Exchange exchange;

    @Autowired
    private ObjectMapper objectMapper;

    public byte[] generatePdf(User user, String statementType) {
        try {
            String userJson = objectMapper.writeValueAsString(user);
            return (byte[]) rabbitTemplate.convertSendAndReceive(exchange.getName(),
                    statementType,
                    new Message(userJson.getBytes()));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        }
    }

}
