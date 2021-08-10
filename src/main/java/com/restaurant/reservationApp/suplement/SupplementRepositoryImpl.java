package com.restaurant.reservationApp.suplement;

import com.restaurant.reservationApp.drink.DrinkRepositoryImpl;
import com.restaurant.reservationApp.food.FoodRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SupplementRepositoryImpl implements SupplementRepository {
    private List<Supplement> supplements = new ArrayList<>(Arrays.asList(
            new Supplement(1, new DrinkRepositoryImpl().getAllDrinks(),new FoodRepositoryImpl().getAllFood())
    ));

    @Override
    public List<Supplement> getAllSupplements() {
        return supplements;
    }

    @Override
    public Supplement getSupplementById(long id) {
        for (Supplement supplement : supplements
        ) {
            if (supplement.getId() == id) {
                return supplement;
            }

        }
        return null;
    }
}
