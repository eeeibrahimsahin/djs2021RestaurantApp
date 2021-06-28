package com.restaurant.reservationApp.drink;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DrinkRepositoryImpl implements DrinkRepository {
    private List<Drink> drinkList = new ArrayList<>();

    public DrinkRepositoryImpl() {
        Drink drink = new Drink();
        drink.setId(1);
        drink.setName("Wine");
        drinkList.add(drink);
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkList;
    }

    @Override
    public Drink getDrinkById(long id) {
        Optional<Drink> searchedDrink = drinkList.stream().filter(drink -> drink.getId() == id).findFirst();
        return searchedDrink.get();
    }

    @Override
    public Drink createDrink(Drink drink) {
        drink.setId(drinkList.size() + 1);
        drinkList.add(drink);
        return drink;
    }
}
