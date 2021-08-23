package com.restaurant.reservationApp.menu;

import com.restaurant.reservationApp.dish.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "menu")
public class Menu {
    @Transient
    public static final String SEQUENCE_NAME = "menu_sequence";
    @Id
    private long id;
    private String name;
    private String description;
    private String type;
    private double price;
}
