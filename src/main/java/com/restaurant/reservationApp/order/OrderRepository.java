package com.restaurant.reservationApp.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
//    public List<Order> getAllOrder();
//
//    public Order getOrderById(long id);
//
//    public Order createOrder(Order order);
//
//    Order addDishToOrder(int id, List<Dish> dish);
}
