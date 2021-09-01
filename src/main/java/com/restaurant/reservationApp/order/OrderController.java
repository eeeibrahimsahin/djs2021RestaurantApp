package com.restaurant.reservationApp.order;

import com.restaurant.reservationApp.auth.CustomUserDetails;
import com.restaurant.reservationApp.dish.Dish;
import com.restaurant.reservationApp.dish.DishService;
import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private TableService tableService;
    @Autowired
    private DishService dishService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrder() {
        List<Order> allOrders = orderService.getAllOrders();
        orderService.getAllOrders().forEach(System.out::println);
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(name = "id", required = true) long id) {
        Optional<Order> order = orderService.getOrderById(id);
        if (order.isPresent())
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        return null; // TODO:
    }

    @PostMapping(value = "/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        System.out.println("order = " + order);
        order.getDishes().forEach(System.out::println);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
        order.setEmployee(userDetails.getUser());
        order.getDishes().forEach(dishService::createDish);
        order.setTable(tableService.getTableById(order.getTable().getId()).get());
        Order newOrder = orderService.createOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }
}

