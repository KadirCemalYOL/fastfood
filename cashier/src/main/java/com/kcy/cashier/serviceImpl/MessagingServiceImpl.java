package com.kcy.cashier.serviceImpl;

import com.kcy.cashier.service.MessagingService;
import messageobject.Order;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingServiceImpl implements MessagingService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Queue workQueue;

    @Override
    public void sendMessage(Order order) {
        rabbitTemplate.convertAndSend(workQueue.getName(), order);
    }
}