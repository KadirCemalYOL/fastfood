package com.kcy.cashier.service;

import messageobject.Menu;
import messageobject.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    MessagingService messagingService;

    @Autowired
    Menu menu;

    public UUID sendOrderRequestToCooks(List<Integer> itemIdList) {
        // Generate orderId(Use this to put it in cache.)
        Order order = new Order();
        itemIdList.forEach(itemId -> order.addRequestedMenuItem(menu.getItem(itemId)));

        messagingService.sendMessage(order);

        return order.getOrderId();
    }
}