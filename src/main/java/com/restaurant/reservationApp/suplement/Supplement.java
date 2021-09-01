package com.restaurant.reservationApp.suplement;

import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.food.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Supplement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<Drink> drinkList;
    @OneToMany
    private List<Food> foodList;

}
