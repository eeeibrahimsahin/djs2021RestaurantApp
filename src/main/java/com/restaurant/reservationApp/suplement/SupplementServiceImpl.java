package com.restaurant.reservationApp.suplement;

import com.restaurant.reservationApp.db.SequenceGeneratorService;
import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.drink.DrinkService;
import com.restaurant.reservationApp.food.Food;
import com.restaurant.reservationApp.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SupplementServiceImpl implements SupplementService {
    @Autowired
    private SupplementRepository supplementRepository;
    @Autowired
    private FoodService foodService;
    @Autowired
    private DrinkService drinkService;
    @Autowired
    SequenceGeneratorService sequenceGenerator;

    @Override
    public List<Supplement> getAllSupplements() {
        List<Supplement> supplements = new ArrayList<>();
        Iterable<Supplement> supplementIterable = supplementRepository.findAll();
        supplementIterable.forEach(supplements::add);
        return supplements;
    }

    @Override
    public Supplement createSupplement(Supplement supplement) {
        supplement.setId(sequenceGenerator.generateSequence(Supplement.SEQUENCE_NAME));
        return supplementRepository.save(supplement);
    }

    @Override
    public Optional<Supplement> getSupplementById(long id) {
        return supplementRepository.findById(id);
    }

    @Override
    public List getSupplementsLessThan(long amount) {
        List<Drink> drinkList = new ArrayList<>();
        List<Food> foodList = foodService.getAllFood();
        Iterable<Drink> drinkIterable = drinkService.getAllDrinks();
        drinkIterable.forEach(drinkList::add);
        List list = new ArrayList();
        foodList.stream().filter(food -> food.getQuantity() < amount).forEach(list::add);
        drinkList.stream().filter(drink -> drink.getQuantity() < amount).forEach(list::add);
        System.out.println("drinkList = " + drinkList);
        System.out.println("list = " + list);
        return list;

    }

}
