package com.company;


import com.company.model.Car;

import static com.company.logic.CarComputation.*;
import static com.company.test.Tests.testFunctions;

public class Main {


    public static void main(String[] args) {
        testFunctions();
        System.out.println("The cheapest car is : "+ displayTheCheapestCar());
        System.out.println();
        System.out.println("The fastest car is: "+ displayTheFastestCar());
        System.out.println();
        System.out.println("Cars manufactured in the year 2019 are: ");
        for(Car car:manufacturedByGivenYear(2019))

            System.out.println(car.toString());

    }
}
