package com.restaurant.reservationApp.drink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "drinks")
public class Drink {
    @Transient
    public static final String SEQUENCE_NAME = "drinks_sequence";
    @Id
    private long id;
    private String name;
    private String type;
    private int quantity;
    private String typeOfQuantity;
    private double price;

}
