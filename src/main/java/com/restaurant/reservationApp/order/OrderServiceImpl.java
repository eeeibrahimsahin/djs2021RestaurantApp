package com.restaurant.reservationApp.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        Iterable<Order> orderIterable = orderRepository.findAll();
        orderIterable.forEach(orders::add);
        return orders;
    }

    @Override
    public Optional<Order> getOrderById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

//    @Override
//    public Order addDishToOrder(int id, List<Dish> dish) {
//        return orderRepository.addDishToOrder(id, dish);
//    }
}

