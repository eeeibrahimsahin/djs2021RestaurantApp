package com.restaurant.reservationApp.drink;

import java.util.List;

public interface DrinkService {
    Iterable<Drink> getAllDrinks();

    Drink getDrinkById(int id);

    Drink createDrink(Drink drink);

    void saveAllDrink(List<Drink> drinkList);
}
