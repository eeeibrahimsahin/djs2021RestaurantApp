package com.restaurant.reservationApp.food;

import com.restaurant.reservationApp.drink.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Override
    public List<Food> getAllFood() {
        return foodRepository.getAllFood() ;
    }

    @Override
    public Food getFoodById(long id) {
        return foodRepository.getFoodById(id);
    }


    @Override
    public Food createFood(Food food) {
        return foodRepository.createFood(food);
    }
}

