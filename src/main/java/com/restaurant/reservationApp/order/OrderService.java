package com.restaurant.reservationApp.order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();

    Optional<Order> getOrderById(long id);

    Order createOrder(Order order);

    void saveAllOrder(List<Order> orderList);

    //Order addDishToOrder(int id, List<Dish> dish);
}
