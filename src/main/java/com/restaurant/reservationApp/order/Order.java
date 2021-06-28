package com.restaurant.reservationApp.order;

import com.restaurant.reservationApp.employee.Employee;

public class Order {
    private long id;
    //private Table table;
    private Employee employee;
    //private Reservation reservation;
    //private List<Food> foodList;
    //private List<Drink> drinkList;
    //private List<Dessert> dessertList;
    private boolean isDiet;

    public Order() {
    }

    public Order(long id, Employee employee, boolean isDiet) {
        this.id = id;
        this.employee = employee;
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
}
