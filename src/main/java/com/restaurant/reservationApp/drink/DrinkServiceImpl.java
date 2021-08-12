package com.restaurant.reservationApp.drink;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    @Override
    public Iterable<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Drink getDrinkById(int id) {
        Optional<Drink> drink = drinkRepository.findById(id);
        if (drink.isPresent())
            return drink.get();
        return null; // we can throw error instead of null
    }

    @Override
    public Drink createDrink(Drink drink) {
        return drinkRepository.save(drink);
    }
}
