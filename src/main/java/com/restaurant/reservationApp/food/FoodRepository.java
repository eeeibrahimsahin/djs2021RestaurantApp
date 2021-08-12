package com.restaurant.reservationApp.food;

import com.restaurant.reservationApp.drink.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {
   /* List<Food> getAllFood();

    Food getFoodById(long id);

    public Food createFood(Food food);*/
}
