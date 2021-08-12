package com.restaurant.reservationApp.order;

import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.reservation.Reservation;
import com.restaurant.reservationApp.table.Table;

import javax.persistence.*;
import java.util.List;
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
    @OneToMany
    private List<Drink> drinkList;
    //private List<Dessert> dessertList;
    private boolean isDiet;

    public Order() {
    }

    public Order(long id, Table table, Employee employee, Reservation reservation, List<Drink> drinkList, boolean isDiet) {
        this.id = id;
        this.table = table;
        this.employee = employee;
        this.reservation = reservation;
    //    this.dishes = dishes;
        this.drinkList = drinkList;
        this.isDiet = isDiet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isDiet() {
        return isDiet;
    }

    public void setDiet(boolean diet) {
        isDiet = diet;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public void addDrinkToList(Drink drink) {
        this.drinkList.add(drink);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
