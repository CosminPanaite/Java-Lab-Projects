package com.company.logic;

import com.company.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarComputation {


    public static List<Car> storageCars() {
        List<Car> carList = new ArrayList<>();
        Car c1 = new Car(2, "Suzuki Vitara", 20000, 2015, 230);
        Car c2 = new Car(3, "Dacia Duster", 15000, 2012, 220);
        Car c3 = new Car(4, "Ford Kuga", 30000, 2019, 250);
        Car c4 = new Car(5, "Nissan Juke", 183000, 2019, 240);
        carList.add(c1);
        carList.add(c2);
        carList.add(c3);
        carList.add(c4);
        return carList;
    }

    public static String displayTheCheapestCar() {
        int minimumPrice = storageCars().get(0).getPrice();
        Car cheapestCar = new Car();
        for (Car car : storageCars()) {
            if (car.getPrice() < minimumPrice) {
                minimumPrice = car.getPrice();
                cheapestCar = car;
            }
        }
        return cheapestCar.toString();
    }

    public static String displayTheFastestCar() {
        int maximumSpeed = -100;
        Car fastestCar = new Car();
        for (Car car : storageCars()) {
            if (car.getSpeed() > maximumSpeed) {
                maximumSpeed = car.getSpeed();
                fastestCar = car;
            }
        }
        return fastestCar.toString();
    }

    public static List<Car> manufacturedByGivenYear(int year) {
        List<Car> carList = new ArrayList<>();
        for (Car car : storageCars()) {
            if (car.getYear() == year) {
                carList.add(car);
            }
        }
        return carList;
    }
}
