package com.restaurant.reservationApp.dish;

import com.restaurant.reservationApp.db.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    SequenceGeneratorService sequenceGenerator;

    @Override
    public Dish createDish(Dish dish) {
        dish.setId(sequenceGenerator.generateSequence(Dish.SEQUENCE_NAME));
        return dishRepository.save(dish);
    }

    @Override
    public void saveAllDish(List<Dish> dishList) {
        dishList.forEach(dish -> createDish(dish));
    }
}
