package com.restaurant.reservationApp.drink;

public interface DrinkService {
    public Iterable<Drink> getAllDrinks();

    public Drink getDrinkById(int id);

    public Drink createDrink(Drink drink);
}
