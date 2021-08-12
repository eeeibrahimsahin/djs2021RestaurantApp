package com.restaurant.reservationApp.order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Order> getAllOrders();

    public Optional<Order> getOrderById(long id);

    public Order createOrder(Order order);

    //Order addDishToOrder(int id, List<Dish> dish);
}
