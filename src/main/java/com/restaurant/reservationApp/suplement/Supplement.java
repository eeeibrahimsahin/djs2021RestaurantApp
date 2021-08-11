package com.restaurant.reservationApp.suplement;

import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.food.Food;

import java.util.List;

public class Supplement {
    private long id;
    private List<Drink> drinkList;
    private List<Food> foodList;

    public Supplement (){

    }

    public Supplement(long id, List<Drink> drinkList, List<Food> foodList) {
        this.id = id;
        this.drinkList = drinkList;
        this.foodList = foodList;
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

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
