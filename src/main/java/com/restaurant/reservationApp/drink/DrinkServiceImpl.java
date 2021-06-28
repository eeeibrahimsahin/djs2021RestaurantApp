package com.restaurant.reservationApp.drink;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.getAllDrinks();
    }

    @Override
    public Drink getDrinkById(long id) {
        return drinkRepository.getDrinkById(id);
    }

    @Override
    public Drink createDrink(Drink drink) {
        return drinkRepository.createDrink(drink);
    }
}
