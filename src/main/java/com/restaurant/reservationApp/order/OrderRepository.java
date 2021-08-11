package com.restaurant.reservationApp.order;

import java.util.List;

public interface OrderRepository {
    public List<Order> getAllOrder();

    public Order getOrderById(long id);

    public Order createOrder(Order order);

    Order addDishToOrder(int id, List<Dish> dish);
}
