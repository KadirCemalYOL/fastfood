package com.kcy.cashier.service;

import messageobject.Order;

public interface MessagingService {
    void sendMessage(Order order);
}
