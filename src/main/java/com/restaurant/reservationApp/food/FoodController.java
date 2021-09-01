package com.restaurant.reservationApp.food;

import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.food.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FoodController {
    @Autowired
    FoodService serviceFood;

    @GetMapping(value = "/foods", produces = "application/json")
    public ResponseEntity<List<Food>> getAllFood() {

        return new ResponseEntity<>(serviceFood.getAllFood(), HttpStatus.OK);
    }

    @GetMapping("/foodsById/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable(name = "id", required = true) long id) {
        Optional<Food> foodOptional = serviceFood.getFoodById(id);
        if (foodOptional.isPresent())
            return new ResponseEntity<>(foodOptional.get(), HttpStatus.OK);
        return null;
    }

    @PutMapping(value = "/food", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Food> createEmployee(@RequestBody Food food) {
        Food food1 = serviceFood.createFood(food);
        return new ResponseEntity<>(food1, HttpStatus.OK);
    }

}
