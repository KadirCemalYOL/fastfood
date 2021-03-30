package com.kcy.cashier.service;

import commonobject.Product;
import messageobject.Order;
import constants.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface CashierService {
    Order processOrder(List<Integer> itemIdList);

    OrderStatus getOrderStatus(UUID orderId);

    Product getProductFromCache(UUID orderId);
}
