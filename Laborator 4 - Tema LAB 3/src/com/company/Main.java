package com.company;


import com.company.Domain.Appointment;
import com.company.Domain.Patient;
import com.company.Exceptions.RepoExceptions;
import com.company.repository.*;

import java.io.EOFException;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        appointmentRepository.add(new Appointment(1, 2, "20/10/2021"));
        for (Appointment appointment : appointmentRepository.findAll())
            System.out.println(appointment);
        AppointmentRepositoryFile appointmentRepositoryFile = new AppointmentRepositoryFile("D:\\FACULTA SEM 3\\MAP\\Laborator 4 - Tema LAB 3\\src\\com\\company\\appointments.txt");
        //appointmentRepositoryFile.add(new Appointment(1,3,"20.10.2021"));
        PatientRepositoryFile patientRepositoryFile = new PatientRepositoryFile("\\D:\\FACULTA SEM 3\\MAP\\Laborator 4 - Tema LAB 3\\src\\com\\company\\patients.txt");
        //patientRepositoryFile.add(new Patient(1,"Charles","Godson",20,"Tartru"));
        //patientRepositoryFile.add(new Patient(2,"Carlo","Angel",15,"Decay"));

        Patient patientToRemove = new Patient(1, "Charles", "Godson", 0, "Tartru");
        patientRepositoryFile.delete(patientToRemove);
        Patient toBeUpdated = new Patient(1, "Chales", "Godson", 15, "No problems");
        patientRepositoryFile.add(patientToRemove);
        patientRepositoryFile.update(toBeUpdated, 1);
        PatientRepository patientRepository = new PatientRepository();

        //try {
        //  PatientRepositorySerialization patientRepositorySerialization = new PatientRepositorySerialization("\\D:\\FACULTA SEM 3\\MAP\\Laborator 4 - Tema LAB 3\\src\\com\\company\\patientSerialization");
        //patientRepositorySerialization.add(patientToRemove);
        //for (Patient p : patientRepositorySerialization.findAll()) {
        //  System.out.println(p);
        //}
        //} catch (RepoExceptions repoExceptions) {
        //  System.out.println(repoExceptions.getMessage());
        //}
        Patient p1 = new Patient();
        PatientRepositorySerialization patientRepositorySerialization = new PatientRepositorySerialization("D:\\FACULTA SEM 3\\MAP\\Laborator 4 - Tema LAB 3\\src\\com\\company\\patientSerialization");
        //patientRepositorySerialization.add(p1);
        AppointmentRepositorySerialization appointmentRepositorySerialization=new AppointmentRepositorySerialization("D:\\FACULTA SEM 3\\MAP\\Laborator 4 - Tema LAB 3\\src\\com\\company\\appointmentSer");
        Appointment appointment=new Appointment();
//        appointmentRepositorySerialization.add(appointment);
        patientRepositoryFile.delete(patientToRemove);
}}



