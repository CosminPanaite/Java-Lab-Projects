package com.company;

import Operations.DeserializationList;
import Operations.SerializationList;
import Operations.SerializationList.*;
import model.Car;
import repository.CarRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        Car model = new Car(7, "Audi A8", 25000, 2018, 240);
        Car model2 = new Car(8, "Peageout", 12000, 2012, 180);
        Car model3 = new Car(9, "Dacia Duster", 14000, 2012, 200);
        Car updateModel = new Car(11, "Golf 4", 10000, 2015, 200);
        carRepository.add(new Car(1, "Suzuki Vitara", 20000, 2015, 230));
        carRepository.add(new Car(2, "Ford Puma", 20000, 2015, 210));
        carRepository.add(new Car(3, "Nissan Juke", 19000, 2018, 200));
        carRepository.add(new Car(4, "Ford Kuga", 30000, 2021, 280));
        carRepository.add(new Car(5, "Kia Sportage", 23000, 2015, 240));
        carRepository.add(new Car(6, "Nisan Qasqai", 26000, 2018, 210));

        carRepository.add(model);
        carRepository.add(model2);

        carRepository.update(updateModel, 5);
//        for (Car cars : carRepository.findAll()) {
//            System.out.println(cars);
//        }
//        carRepository.delete(model);
//        for (Car cars : carRepository.findAll()) {
//            System.out.println(cars);
//        }
        System.out.println(carRepository.findById(4));
        List<String> CarNames = StreamSupport.stream(carRepository.findAll().spliterator(), false).map(car ->
                car.getModel()).collect(Collectors.toList());
        System.out.println(CarNames);


        List<String> FordCars = StreamSupport.stream(carRepository.findAll().spliterator(), false).filter(
                car -> car.getModel().contains("Ford")).map(car -> car.getModel()).collect(Collectors.toList());
        System.out.println("Cars which contain Ford in their name " + FordCars);

        List<Car> YearsLesserThan2016 = StreamSupport.stream(carRepository.findAll().spliterator(), false).
                filter(car -> car.getYear() < 2016).collect(Collectors.toList());
        System.out.println("List of cars produced before 2016" + YearsLesserThan2016);
        //using predicate
        Predicate<Car> filterCondition = car -> car.getYear() < 2016;
        List<Car> carList = StreamSupport.stream(carRepository.findAll().spliterator(), false).filter(filterCondition).collect(Collectors.toList());
        //map transforma

        List<Car> carList1 = StreamSupport.stream(carRepository.findAll().spliterator(), false).filter(car -> car.getYear() > 2016).collect(Collectors.toList());
        System.out.println("Cars produced after 2016: " + carList1);
        Predicate<Car> filterCondition2 = car -> car.getModel().contains("Ford Kuga");
        List<Integer> YearOfFordKuga = StreamSupport.stream(carRepository.findAll().spliterator(), false).filter(
                car -> car.getModel().contains("Ford")).map(car -> car.getYear()).collect(Collectors.toList());
        System.out.println(YearOfFordKuga);
        System.out.println(YearOfFordKuga.size());
        SerializationList serializationList = new SerializationList();

        try {
            serializationList.writeCarObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        DeserializationList deserializationList=new DeserializationList();
        try
        {
            deserializationList.readCarObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
