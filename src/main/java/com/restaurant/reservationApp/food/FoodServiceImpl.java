package com.restaurant.reservationApp.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Override
    public List<Food> getAllFood() {
        List<Food> foodList = new ArrayList<>();
        Iterable<Food> foods = foodRepository.findAll();
        foods.forEach(foodList::add);
        return foodList;
    }

    @Override
    public Optional<Food> getFoodById(long id) {
        return foodRepository.findById(id);
    }


    @Override
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }
}

