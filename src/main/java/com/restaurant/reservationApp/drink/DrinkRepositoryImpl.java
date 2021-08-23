package com.restaurant.reservationApp.drink;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DrinkRepositoryImpl implements DrinkRepository {
    private List<Drink> drinkList = new ArrayList<>(Arrays.asList(
            new Drink(1, "CocoCola", "Soft", 2000,"box", 1.5),
            new Drink(2, "Pepsi", "Soft", 2000,"box", 1),
            new Drink(3, "Corona", "Beer", 2000, "bottle",3),
            new Drink(4, "Chivas", "Whiskey", 2000, "bottle",10),
            new Drink(5, "Spa", "Soft", 2000,"bottle", 1),
            new Drink(6, "Dujardin Blauw", "Brandy", 2000, "bottle",20),
            new Drink(7, "Heneiken", "Beer", 2000,"bottle", 3),
            new Drink(8, "LeCola", "Soft", 2000,"box", 1),
            new Drink(9, "Guiness", "Beer", 2000,"bottle", 3)

    ));

    public DrinkRepositoryImpl() {
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
