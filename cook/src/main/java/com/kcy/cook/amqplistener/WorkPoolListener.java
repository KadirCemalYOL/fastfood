package com.kcy.cook.amqplistener;

import com.kcy.cook.service.CacheService;
import constants.CacheKeyPrefixes;
import commonobject.Product;
import messageobject.Order;
import constants.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkPoolListener {

    @Autowired
    CacheService cacheService;

    @RabbitListener(queues = "workQueue")
    public void getFromPool(Order order) {
        cacheService.putToCache(CacheKeyPrefixes.STATUS_WITH_ORDER_ID_ + order.getOrderId().toString(), OrderStatus.BEING_PREPARED);

        Product product = new Product(order);
        product.prepare();

        cacheService.putToCache(CacheKeyPrefixes.STATUS_WITH_ORDER_ID_ + order.getOrderId().toString(), OrderStatus.READY);
        cacheService.putToCache(CacheKeyPrefixes.PRODUCT_WITH_ORDER_ID_ + order.getOrderId().toString(), product);
    }
}
