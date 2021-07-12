package com.restaurant.reservationApp.suplement;

import com.restaurant.reservationApp.drink.Drink;

import java.util.List;

public class Supplement {
    private long id;
    private List<Drink> drinkList;

    public Supplement(long id, List<Drink> drinkList) {
        this.id = id;
        this.drinkList = drinkList;
    }
    public Supplement (){

    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
