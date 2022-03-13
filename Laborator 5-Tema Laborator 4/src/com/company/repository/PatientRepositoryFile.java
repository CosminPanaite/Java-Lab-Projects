package com.company.repository;

import com.company.Domain.Patient;
import com.company.Exceptions.RepoExceptions;
import java.io.*;

public class PatientRepositoryFile extends AbstractRepository<Patient,Integer> {
    private String filename;
    public PatientRepositoryFile(String filename){
        this.filename=filename;
        readFromFile();
    }

    private void readFromFile(){
        try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
            String line;
            while((line=reader.readLine())!=null){
                String[] el=line.split(";");
                if(el.length!=5){
                    System.err.println("Not a valid number of atributes "+line);
                    continue;
                }
                try{
                    int Id=Integer.parseInt(el[0]);
                    int age=Integer.parseInt(el[3]);

                    Patient appointment=new Patient(Id,el[1],el[2],age,el[4]);
                    super.add(appointment);
                }
                catch(NumberFormatException n){
                    System.err.println("The ID is not a valid number "+el[0]);
                }
            }
        }
        catch(IOException ex){
            throw new RepoExceptions("Error reading"+ex);
        }
    }

    @Override
    public void add(Patient obj) {
        try{
            super.add(obj);
            writeToFile();
        }
        catch(RuntimeException e){
            throw new RepoExceptions("Object was not added" + e + " " + obj);
        }
    }

    private void writeToFile() {
        try(PrintWriter pw = new PrintWriter(filename)) {
            for(Patient el : findAll()) {
                String line = el.getID() + ";" + el.getFirstName() + ";" + el.getLastName() +
                        ";" + el.getAge() + ";" + el.getProblem() ;
                pw.println(line);
            }
        }
        catch(IOException ex) {
            throw new RepoExceptions("Error writing" + ex);
        }
    }

    @Override
    public void delete(Patient obj){
        try{
            super.delete(obj);
            writeToFile();
        }
        catch(RuntimeException ex){
            throw new RepoExceptions("Object was not deleted"+ex+" "+obj);
        }
    }

    @Override
    public void update(Patient obj, Integer id){
        try{
            super.update(obj, id);
            writeToFile();
        }
        catch(RuntimeException ex){
            throw new RepoExceptions("Object was not updated" + ex + " " + obj);
        }
    }
}
