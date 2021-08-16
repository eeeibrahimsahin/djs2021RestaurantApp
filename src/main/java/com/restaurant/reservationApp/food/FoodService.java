package com.restaurant.reservationApp.food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<Food> getAllFood();

    Optional<Food> getFoodById(long id);

    Food createFood(Food food);

    void saveAllFood(List<Food> foodList);
}
