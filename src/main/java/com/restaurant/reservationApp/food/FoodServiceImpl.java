package com.restaurant.reservationApp.food;

import com.restaurant.reservationApp.db.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    SequenceGeneratorService sequenceGenerator;

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
        food.setId(sequenceGenerator.generateSequence(Food.SEQUENCE_NAME));
        return foodRepository.save(food);
    }

    @Override
    public void saveAllFood(List<Food> foodList) {
        foodList.forEach(food -> createFood(food));
    }
}

