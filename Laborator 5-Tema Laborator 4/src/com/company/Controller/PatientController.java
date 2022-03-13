package com.company.Controller;

import com.company.Domain.Patient;
import com.company.repository.AppointmentRepository;
import com.company.repository.PatientRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PatientController {
    private final PatientRepository repo;

    public PatientController(PatientRepository repo) {
        this.repo = repo;
    }

    public void addObject(Patient patient) {
        repo.add(patient);
    }

    public void deleteObject(Patient patient) {
        repo.delete(patient);
    }

    public void updateObject(Patient patient) {
        repo.update(patient, patient.getID());
    }

    public void searchObject(Patient patient) {
        repo.findById(patient.getID());
    }


    public Iterable<Patient> controllerFindAll() {
        return repo.findAll();
    }

    public Collection<Patient> controllerGetAll() {
        return repo.getAll();
    }


    public List<String> getFirstNamesofPatientsWithAgeGreaterThan20() {
        Collection<Patient> patientCollection = controllerGetAll();
        List<String> patientsNamesList = patientCollection.stream().filter(patient -> patient.getAge() > 20).map(patient -> patient.getFirstName()).collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        for (String firstName : patientsNamesList) {
            result.add(firstName);
        }
        return result;
    }

    public void  printPatientsWithLastNameCarl() {
        Collection<Patient>patientCollection=controllerGetAll();
        //print by cake id =1
        patientCollection.stream()
                .filter(patient -> patient.getLastName().equals("Carl")).
                forEach(System.out::println);
    }
    public void printNumberOfPatientsWithFirstNameStartingWithA(){
        Collection<Patient>patientCollection=controllerGetAll();
        long number;
        number=patientCollection.stream().filter(patient -> patient.getFirstName().startsWith("A")).count();
        System.out.println(number);
    }
}