package com.restaurant.reservationApp.drink;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DrinkRepository extends CrudRepository<Drink, Integer> {
    //public List<Drink> getAllDrinks(); findAll() exists in CrudRepository. We can use it instead of getAllDrinks()
    // public Drink getDrinkById(long id); findById() exists in CrudRepository. We can use it instead of getDrinkById()
    // public Drink createDrink(Drink drink); save() exists in CrudRepository. We can use it instead of createDrink()
}
