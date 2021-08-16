package com.restaurant.reservationApp.dish;

import java.util.List;

public interface DishService {
    Dish createDish(Dish dish);

    void saveAllDish(List<Dish> dishList);
}
