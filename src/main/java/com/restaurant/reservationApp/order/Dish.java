package com.restaurant.reservationApp.order;

import com.restaurant.reservationApp.food.Food;

import javax.persistence.*;
import java.util.List;
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany
    private List<Food> ingredients;

    public Dish() {
    }

    public Dish(int id, String name, List<Food> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Food> ingredients) {
        this.ingredients = ingredients;
    }
}
