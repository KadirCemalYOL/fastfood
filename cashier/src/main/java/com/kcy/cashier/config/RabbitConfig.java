package com.kcy.cashier.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfig {
    static final String queueName = "workQueue";

    @Bean
    Queue workQueue() {
        return new Queue(queueName, true, false, false);
    }
}
