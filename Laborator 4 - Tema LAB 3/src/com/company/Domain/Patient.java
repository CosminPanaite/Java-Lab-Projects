package com.company.Domain;

import java.io.Serializable;
import java.util.Objects;

public class Patient implements Identifiable<Integer>, Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String problem;


    public Integer getAge() {
        return age;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getProblem() {
        return problem;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setProblem(String problem){
        this.problem=problem;
    }

    public Patient(Integer id, String firstName, String lastName, Integer age, String problem) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.problem = problem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id.equals(patient.id) && firstName.equals(patient.firstName) && lastName.equals(patient.lastName) && age.equals(patient.age) && problem.equals(patient.problem);
    }
    public Patient(){
        this.id=0;
        this.firstName="";
        this.age=0;
        this.problem="";
        this.lastName="";
    }

    @Override
    public String toString() {
        return "Patient with ID: " +id+ " with first name "+firstName+" last name "+lastName + " having "+ age+ " ages "+ "and being diagnosided with" + problem;

    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public void setID(Integer id) {
        this.id=id;
    }
}