package com.restaurant.reservationApp.drink;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DrinkController {
    @Autowired
    private DrinkService drinkService;

    @GetMapping("/drinks")
    public ResponseEntity<Iterable<Drink>> getAllDrinks() {
        Iterable<Drink> drinks = drinkService.getAllDrinks();
        return new ResponseEntity<>(drinks, HttpStatus.OK);
    }

    @GetMapping("/drinks/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable(name = "id", required = true) int id) {
        Drink drink = drinkService.getDrinkById(id);
        return new ResponseEntity<>(drink, HttpStatus.OK);
    }

    @PutMapping(value = "/drink", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Drink> createEmployee(@RequestBody Drink drink) {
        System.out.println(drink.getName());
        Drink drink1 = drinkService.createDrink(drink);
        return new ResponseEntity<>(drink1, HttpStatus.OK);
    }
}
