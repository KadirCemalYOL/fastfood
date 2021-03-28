package com.kcy.cashier.service;

import messageobject.Order;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Queue workQueue;

    public void sendMessage(Order order) {
        rabbitTemplate.convertAndSend(workQueue.getName(), order);
    }
}
