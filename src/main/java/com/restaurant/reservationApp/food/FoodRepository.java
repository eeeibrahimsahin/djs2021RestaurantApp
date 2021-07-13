package com.restaurant.reservationApp.food;

import com.restaurant.reservationApp.drink.Drink;

import java.util.List;

public interface FoodRepository {
    List<Food> getAllFood();

    Food getFoodById(long id);
    public Food createFood(Food food);
}
