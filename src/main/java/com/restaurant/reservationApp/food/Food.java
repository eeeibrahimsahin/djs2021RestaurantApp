package com.restaurant.reservationApp.food;

public class Food {
    private int id;
    private String name;
    private String type;
    private double quantity;
    private String typeOfQuantity;
    private double price;

    public Food(){

    }

    public Food(int id, String name, String type, double quantity, double price, String typeOfQuantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.typeOfQuantity=typeOfQuantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setTypeOfQuantity(String typeOfQuantity) {
        this.typeOfQuantity = typeOfQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getTypeOfQuantity() {
        return typeOfQuantity;
    }

    public double getPrice() {
        return price;
    }
}
