package com.restaurant.reservationApp.suplement;

import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.food.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SupplementServiceImpl implements SupplementService {
    @Autowired
    private SupplementRepository supplementRepository;

    @Override
    public List<Supplement> getAllSupplements() {
        List<Supplement> supplements = new ArrayList<>();
        Iterable<Supplement> supplementIterable = supplementRepository.findAll();
        supplementIterable.forEach(supplements::add);
        return supplements;
    }

    @Override
    public Optional<Supplement> getSupplementById(long id) {
        return supplementRepository.findById(id);
    }

    @Override
    public List getSupplementsLessThan(long amount){
        if(!getAllSupplements().isEmpty()) {
            List<Food> foodList = getAllSupplements().get(0).getFoodList();
            List<Drink> drinkList = getAllSupplements().get(0).getDrinkList();
            List list = new ArrayList();

            foodList.stream().filter(food -> food.getQuantity() < amount).forEach(list::add);
            drinkList.stream().filter(drink -> drink.getQuantity() < amount).forEach(list::add);

            return list;
        }
        return null;
    }

}
