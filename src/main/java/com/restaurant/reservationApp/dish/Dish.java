package com.restaurant.reservationApp.dish;

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
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;
    private String type;
    private String allergy;
    private String chairNo;
    @OneToMany
    private List<Food> ingredients;

}
