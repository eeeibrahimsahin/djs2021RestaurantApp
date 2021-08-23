package com.restaurant.reservationApp.dish;

import com.restaurant.reservationApp.order.Order;

import java.util.List;
import java.util.Optional;

public interface DishService {
    Dish createDish(Dish dish);

    Optional<Dish> getOrderById(long id);

    List<Dish> getDishesByIds(long... ids);

    void saveAllDish(List<Dish> dishList);
}
