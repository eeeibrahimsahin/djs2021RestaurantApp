package com.restaurant.reservationApp.order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();

    public Order getOrderById(long id);

    public Order createOrder(Order order);
}
