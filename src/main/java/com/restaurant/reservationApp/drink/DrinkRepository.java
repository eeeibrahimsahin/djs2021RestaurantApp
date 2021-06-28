package com.restaurant.reservationApp.drink;

import java.util.List;

public interface DrinkRepository {
    public List<Drink> getAllDrinks();
    public Drink getDrinkById(long id);
    public Drink createDrink(Drink drink);
}
