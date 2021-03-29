package com.kcy.cook.amqplistener;

import com.kcy.cook.service.CacheService;
import commonobject.Product;
import messageobject.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkPoolListener {

    @Autowired
    CacheService cacheService;

    @RabbitListener(queues = "workQueue")
    public void getFromPool(Order order) {
        Product product = new Product(order);
        product.prepare();

        cacheService.putToCache(order.getOrderId().toString(), product);
    }
}
