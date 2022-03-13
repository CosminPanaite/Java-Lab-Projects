package com.company.test;

import static com.company.logic.CarComputation.*;

import com.company.model.Car;

import java.util.ArrayList;
import java.util.List;


public class Tests {
    public static void testFunctions() {
        Car c2 = new Car(3, "Dacia Duster", 15000, 2012, 220);
        assert  (displayTheCheapestCar().equals(c2.toString()));
        assert (c2.getPrice() == 15000);
        assert (c2.getSpeed() == 220);
        List<Car>checkList=new ArrayList<>();
        Car c3 = new Car(4, "Ford Kuga", 30000, 2019, 250);
        Car c4 = new Car(5, "Nissan Juke", 183000, 2019, 240);
        checkList.add(c3);
        checkList.add(c4);
        assert (manufacturedByGivenYear(2019).equals(checkList));
        System.out.println("ALL TESTS TRUE");

    }


}
