package com.restaurant.reservationApp.drink;


public class Drink {
    private long id;
    private String name;
    private String type;
    private int quantity;
    private String typeOfQuantity;
    private double price;

    public Drink() {
    }

    public Drink(long id, String name, String type, int quantity, String typeOfQuantity, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.typeOfQuantity = typeOfQuantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
