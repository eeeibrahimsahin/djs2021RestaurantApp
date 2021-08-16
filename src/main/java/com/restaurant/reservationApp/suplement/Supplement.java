package com.restaurant.reservationApp.suplement;

import com.restaurant.reservationApp.drink.Drink;
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
@Document(collection = "supplements")
public class Supplement {
    @Transient
    public static final String SEQUENCE_NAME = "supplements_sequence";
    @Id
    private long id;
    @DBRef
    private List<Drink> drinkList;
    @DBRef
    private List<Food> foodList;

}
