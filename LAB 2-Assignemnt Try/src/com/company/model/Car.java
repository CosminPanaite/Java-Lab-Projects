package com.company.model;

public class Car {
    private Integer ID;
    private String Model;
    private Integer Price;
    private Integer Year;
    private Integer Speed;

    public Integer getID() {
        return ID;
    }

    public Integer getSpeed() {
        return Speed;
    }

    public void setSpeed(Integer speed) {
        Speed = speed;
    }

    public Integer getPrice() {
        return Price;
    }

    public Integer getYear() {
        return Year;
    }

    public String getModel() {
        return Model;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public Car() {

    }

    public Car(Integer ID, String Model, Integer Price, Integer Year, int Speed) {
        this.ID = ID;
        this.Model = Model;
        this.Price = Price;
        this.Year = Year;
        this.Speed = Speed;
    }

    public String toString() {
        return "Car with ID  " + ID + " being a " + Model + " being valued at  " + Price + " and manufactured in " + Year + " and can reach the maximum speed of " + Speed + " per hour !";
    }

}
