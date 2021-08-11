package com.restaurant.reservationApp.order;

import com.restaurant.reservationApp.drink.DrinkRepositoryImpl;
import com.restaurant.reservationApp.employee.EmployeeRepositoryImpl;
import com.restaurant.reservationApp.reservation.Reservation;
import com.restaurant.reservationApp.reservation.ReservationRepositoryImpl;
import com.restaurant.reservationApp.table.Table;
import com.restaurant.reservationApp.table.TableRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orderList = new ArrayList<>(Arrays.asList(
            new Order(1, new TableRepositoryImpl().getTableById(5), new EmployeeRepositoryImpl().getEmployeeById(1), new ReservationRepositoryImpl().getReservationById(1), Arrays.asList(new DrinkRepositoryImpl().getDrinkById(1), new DrinkRepositoryImpl().getDrinkById(2)), true),
            new Order(2, new TableRepositoryImpl().getTableById(2), new EmployeeRepositoryImpl().getEmployeeById(2), new ReservationRepositoryImpl().getReservationById(2), Arrays.asList(new DrinkRepositoryImpl().getDrinkById(8), new DrinkRepositoryImpl().getDrinkById(4)), false),
            new Order(3, new TableRepositoryImpl().getTableById(2), new EmployeeRepositoryImpl().getEmployeeById(3), new ReservationRepositoryImpl().getReservationById(3), Arrays.asList(new DrinkRepositoryImpl().getDrinkById(7), new DrinkRepositoryImpl().getDrinkById(5)), true),
            new Order(4, new TableRepositoryImpl().getTableById(1), new EmployeeRepositoryImpl().getEmployeeById(4), new ReservationRepositoryImpl().getReservationById(4), Arrays.asList(new DrinkRepositoryImpl().getDrinkById(3), new DrinkRepositoryImpl().getDrinkById(6)), false)
    ));

    public OrderRepositoryImpl() {
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

    @Override
    public Order addDishToOrder(int id, List<Dish> dishes) {
        Optional<Order> optionalOrder = orderList.stream().filter(order -> order.getId() == id).findFirst();
        if(optionalOrder.isPresent()){
            optionalOrder.get().getDishes().addAll(dishes);
        }
        return null;
    }
}

