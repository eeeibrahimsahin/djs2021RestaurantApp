package com.restaurant.reservationApp.drink;

import com.restaurant.reservationApp.db.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    SequenceGeneratorService sequenceGenerator;

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
        drink.setId(sequenceGenerator.generateSequence(Drink.SEQUENCE_NAME));
        return drinkRepository.save(drink);
    }

    @Override
    public void saveAllDrink(List<Drink> drinkList) {
        drinkList.forEach(drink -> createDrink(drink));
    }
}
