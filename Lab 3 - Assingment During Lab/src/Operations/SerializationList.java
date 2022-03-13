package Operations;

import model.Car;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;

public class SerializationList {
    public SerializationList() {
    }

    public void writeCarObject() throws  IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("D:\\FACULTA SEM 3\\MAP\\Lab 3 - Assingment During Lab\\src\\CarsSer");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Car car1 = new Car(1, "Peaugeout", 20000, 2010, 180);
            Car car2 = new Car(1, "Porche", 70000, 2017, 280);
            Car car3 = new Car(1, "Ford", 20000, 2013, 190);
            List<Car> carList = new ArrayList<>();
            carList.add(car1);
            carList.add(car2);
            carList.add(car3);
            objectOutputStream.writeObject(carList);
            System.out.println("Successfully written list of employee objects to the file");
        } finally {
            if (objectOutputStream != null)
                objectOutputStream.close();
        }


    }
}
