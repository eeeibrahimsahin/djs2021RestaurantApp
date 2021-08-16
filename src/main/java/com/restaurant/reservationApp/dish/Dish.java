package com.restaurant.reservationApp.dish;

import com.restaurant.reservationApp.food.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "dishes")
public class Dish {
    @Transient
    public static final String SEQUENCE_NAME = "dishes_sequence";
    @Id
    private long id;
    private String name;
    @DBRef
    private List<Food> ingredients;

}
