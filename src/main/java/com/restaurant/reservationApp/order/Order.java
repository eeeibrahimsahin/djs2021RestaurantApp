package com.restaurant.reservationApp.order;

import com.restaurant.reservationApp.dish.Dish;
import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.reservation.Reservation;
import com.restaurant.reservationApp.table.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(collection = "orders")
public class Order {
    @Transient
    public static final String SEQUENCE_NAME = "orders_sequence";
    @Id
    private long id;
    @DBRef
    private Table table;
    @DBRef
    private Employee employee;
    @DBRef
    private Reservation reservation;
    @DBRef
    private List<Dish> dishes;
    @DBRef
    private List<Drink> drinkList;
    //private List<Dessert> dessertList;
    private boolean isDiet;

}
