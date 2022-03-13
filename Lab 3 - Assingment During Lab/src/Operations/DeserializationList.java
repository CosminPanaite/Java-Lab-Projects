package Operations;

import model.Car;

import java.io.*;
import java.util.List;

public class DeserializationList {
    public DeserializationList() {
    }
    public void readCarObject()throws IOException
    {
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
        try{
            fileInputStream=new FileInputStream("D:\\FACULTA SEM 3\\MAP\\Lab 3 - Assingment During Lab\\src\\CarsSer");
            objectInputStream =new ObjectInputStream(fileInputStream);
            List<Car>carList=(List<Car>) objectInputStream.readObject();
            for(Car elems:carList){
                System.out.println(elems);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
