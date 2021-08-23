package com.restaurant.reservationApp.dish;

import com.restaurant.reservationApp.db.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    public Optional<Dish> getOrderById(long id) {
        return dishRepository.findById(id);
    }

    @Override
    public List<Dish> getDishesByIds(long... ids) {
        List<Dish> dishes = new ArrayList<>();
        for (long id : ids) {
            Optional<Dish> optionalDish = dishRepository.findById(id);
            if (optionalDish.isPresent())
                dishes.add(optionalDish.get());
        }
        return dishes;
    }

    @Override
    public void saveAllDish(List<Dish> dishList) {
        dishList.forEach(dish -> createDish(dish));
    }
}
