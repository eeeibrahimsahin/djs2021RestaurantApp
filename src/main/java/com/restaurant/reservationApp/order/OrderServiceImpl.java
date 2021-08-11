package com.restaurant.reservationApp.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrder();
    }

    @Override
    public Order getOrderById(long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    @Override
    public Order addDishToOrder(int id,List<Dish> dish) {
        return orderRepository.addDishToOrder(id,dish);
    }
}

