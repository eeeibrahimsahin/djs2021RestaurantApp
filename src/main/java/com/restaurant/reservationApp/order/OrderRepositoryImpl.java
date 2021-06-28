package com.restaurant.reservationApp.order;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    private List<Order> orderList = new ArrayList<>();

    public OrderRepositoryImpl() {
        Order order = new Order();
        order.setId(1);
        order.setDiet(true);
        orderList.add(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderList;
    }

    @Override
    public Order getOrderById(long id) {
        Optional<Order> searchOrder = orderList.stream().filter(order -> order.getId() == id).findFirst();
        return searchOrder.get();
    }

    @Override
    public Order createOrder(Order order) {
        order.setId(orderList.size() + 1);
        orderList.add(order);
        return order;
    }
}

