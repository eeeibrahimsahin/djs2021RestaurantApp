package com.restaurant.reservationApp.suplement;

import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.food.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SupplementServiceImpl implements SupplementService {
    @Autowired
    private SupplementRepository supplementRepository;

    @Override
    public List<Supplement> getAllSupplements() {
        return supplementRepository.getAllSupplements();
    }

    @Override
    public Supplement getSupplementById(long id) {
        return supplementRepository.getSupplementById(id);
    }

    @Override
    public List getSupplementsLessThan(long amount){
        List<Food> foodList = supplementRepository.getAllSupplements().get(0).getFoodList();
        List<Drink> drinkList = supplementRepository.getAllSupplements().get(0).getDrinkList();
        List list = new ArrayList();

        foodList.stream().filter(food -> food.getQuantity()<amount).forEach(list::add);
        drinkList.stream().filter(drink -> drink.getQuantity()<amount).forEach(list::add);

        return list;
    }

    @Override
    public Supplement createSupplement(Supplement supplement) {
        return null;
    }

}
