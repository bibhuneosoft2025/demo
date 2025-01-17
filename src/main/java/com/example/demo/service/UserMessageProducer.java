package com.example.demo.service;


import com.example.demo.config.RabbitMQConfig;
import com.example.demo.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendUserMessage(User user) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, user);
        System.out.println("Sent message: " + user);
    }
}

