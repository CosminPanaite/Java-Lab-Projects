package com.company;


import com.company.Controller.AppointmentController;
import com.company.Controller.PatientController;
import com.company.Domain.Appointment;
import com.company.Domain.Patient;
import com.company.repository.*;

public class Main {

    public static void main(String[] args) {
        AppointmentRepositorySerialization serAppointmentFile=new AppointmentRepositorySerialization("D:\\FACULTA SEM 3\\MAP\\Laborator 5-Tema Laborator 4\\src\\com\\company\\patientSerialization");
        PatientRepositorySerialization serPatientFile=new PatientRepositorySerialization("D:\\FACULTA SEM 3\\MAP\\Laborator 5-Tema Laborator 4\\src\\com\\company\\patientSerialization");
        AppointmentRepository appointmentRepository=new AppointmentRepository();
        AppointmentController appointmentController=new AppointmentController(appointmentRepository);
        Appointment a=new Appointment(6,6,"20.06.2021");
        appointmentController.addObject(a);
        System.out.println("Appointments with ID<1: "+appointmentController.getAppointemntWithIdGreaterThanFour());
        System.out.println();
        PatientRepository patientRepository=new PatientRepository();
        PatientController patientController=new PatientController(patientRepository);
        Patient p=new Patient(2,"Steve","Carl",25,"Tartre");
        patientController.addObject(p);
        System.out.println("First names of patients >20 years : "+patientController.getFirstNamesofPatientsWithAgeGreaterThan20());
        System.out.println();
        patientController.printPatientsWithLastNameCarl();
        System.out.println();
        System.out.print("Number of patients with first name starting with A : ");
        patientController.printNumberOfPatientsWithFirstNameStartingWithA();

        System.out.println();
        System.out.println("Id of appointments from 2021: "+ appointmentController.getIdOfAppointmentsAppointmentsFrom2021());

          }}



