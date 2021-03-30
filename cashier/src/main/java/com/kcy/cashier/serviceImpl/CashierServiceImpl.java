package com.kcy.cashier.serviceImpl;

import com.kcy.cashier.service.CacheService;
import com.kcy.cashier.service.CashierService;
import com.kcy.cashier.service.MessagingService;
import commonobject.Product;
import constants.CacheKeyPrefixes;
import messageobject.Menu;
import messageobject.Order;
import constants.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CashierServiceImpl implements CashierService {

    @Autowired
    Menu menu;

    @Autowired
    CacheService cacheService;

    @Autowired
    MessagingService messagingService;

    @Override
    public Order processOrder(List<Integer> itemIdList) {
        Order order = new Order();
        itemIdList.forEach(itemId -> order.addRequestedMenuItem(menu.getItem(itemId)));

        // Put order status to cache.
        cacheService.putToCache(CacheKeyPrefixes.STATUS_WITH_ORDER_ID_ + order.getOrderId().toString(), OrderStatus.IN_THE_QUEUE);

        // Send order message to cooks.
        messagingService.sendMessage(order);

        return order;
    }

    @Override
    public OrderStatus getOrderStatus(UUID orderId) {
        Object status = cacheService.getFromCache(CacheKeyPrefixes.STATUS_WITH_ORDER_ID_ + orderId.toString());

        if (status == null) {
            return null;
        } else {
            return (OrderStatus) status;
        }
    }

    @Override
    public Product getProductFromCache(UUID orderId) {
        Object product = cacheService.getFromCache(CacheKeyPrefixes.PRODUCT_WITH_ORDER_ID_ + orderId.toString());

        if (product != null) {
            cacheService.removeFromCache(CacheKeyPrefixes.PRODUCT_WITH_ORDER_ID_ + orderId.toString());
            // TODO TTL should be added for delivered product status to limit redis growth.
            cacheService.putToCache(CacheKeyPrefixes.STATUS_WITH_ORDER_ID_ + orderId.toString(), OrderStatus.DELIVERED);

            return (Product) product;
        } else {
            return null;
        }
    }
}
