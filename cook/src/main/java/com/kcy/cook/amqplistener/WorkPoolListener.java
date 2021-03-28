package com.kcy.cook.amqplistener;

import commonobject.Product;
import messageobject.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkPoolListener {

    @RabbitListener(queues = "workQueue")
    public void getFromPool(Order order) {
        Product product = new Product(order);
        product.prepare();

        // TODO Put prepared product to cache.
    }
}
