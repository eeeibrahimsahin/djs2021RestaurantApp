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

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Table table;
    @OneToOne
    private Employee employee;
    @OneToOne
    private Reservation reservation;
    @OneToMany
    private List<Dish> dishes;
    @ElementCollection
    private List<String> specialNotes;
    @OneToMany
    private List<Drink> drinkList;
    //private List<Dessert> dessertList;
    private boolean isDiet;
    private boolean isPaid;

}
