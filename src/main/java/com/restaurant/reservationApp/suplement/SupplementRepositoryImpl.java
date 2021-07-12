package com.restaurant.reservationApp.suplement;

import com.restaurant.reservationApp.drink.DrinkRepositoryImpl;
import com.restaurant.reservationApp.drink.DrinkService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class SupplementRepositoryImpl implements SupplementRepository {
    private List<Supplement> supplements = new ArrayList<>(Arrays.asList(
            new Supplement(1, new DrinkRepositoryImpl().getAllDrinks())
    ));
    @Override
    public List<Supplement> getAllSupplements() {
        return supplements;
    }
}
