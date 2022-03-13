package com.company.UserInterface;

import com.company.AbstractController.AppointmentController;
import com.company.AbstractController.PatientController;
import com.company.Domain.Appointment;
import com.company.Domain.Patient;
import com.company.PatientComparator.PatientComparator;


import java.util.*;
import java.util.stream.Collectors;

public class UserInterface {


    private AppointmentController appointmentController;
    private PatientController patientController;
    public UserInterface(AppointmentController appointmentController,PatientController patientController)
    {
        this.patientController=patientController;
        this.appointmentController=appointmentController;
    }
    public void showMenu() {

        System.out.println("1. ADD A PATIENT");
        System.out.println("2. SHOW ALL PATIENTS");
        System.out.println("3. MAKE AN APPOINTMENT");
        System.out.println("4. DELETE AN APPOINTMENT");
        System.out.println("5. SHOW ALL APPOINTMENTS");
        System.out.println("6. SHOW THE YOUNGEST PATIENT");
        System.out.println("7. SHOW THE JIMMYS ON THE LIST");
        System.out.println("8. SHOW THE APPOINTEMNTS WITH ID > 2");
        System.out.println("x. EXIT");
    }

    public void addPatient() {
        System.out.println("Enter patient ID: ");
        Scanner scannerID = new Scanner(System.in);
        Integer ID = scannerID.nextInt();

        System.out.println("Enter first name: ");
        Scanner scannerFirstName = new Scanner(System.in);
        String firstName = scannerFirstName.nextLine();

        System.out.println("Enter last name: ");
        Scanner scannerLastName = new Scanner(System.in);
        String lastName = scannerLastName.nextLine();

        System.out.println("Enter patient's problem: ");
        Scanner scannerProblem = new Scanner(System.in);
        String problem = scannerProblem.nextLine();

        System.out.println("Enter age: ");
        Scanner scannerAge = new Scanner(System.in);
        Integer age = scannerAge.nextInt();

        patientController.save(ID, firstName, lastName, age, problem);
    }

    public void addApointment() {
        System.out.println("Enter appointment ID:");
        Scanner scannerID = new Scanner(System.in);
        Integer ID = scannerID.nextInt();
        System.out.println("Enter Patient ID: ");
        Scanner scannerPatientID = new Scanner(System.in);
        Integer patientID = scannerPatientID.nextInt();
        System.out.println("Enter date of appoint: ");
        Scanner scannerDate = new Scanner(System.in);
        String date = scannerDate.nextLine();
        appointmentController.save(ID, patientID, date);

    }

    public void showAllPatients() {
        for (Patient patient : patientController.getAllPatients()) {
            System.out.println(patient.toString());
        }
    }

    public void showTheYoungest() {
        Collections.sort(patientController.getAllPatients(), new PatientComparator());
        List<Patient> patientList = new ArrayList<>();
        patientList.add(patientController.getAllPatients().get(0));
        for(Patient p:patientList)
        {
            System.out.println(p);
        }
    }

    public void showAllAppointments() {
        for (Appointment app : appointmentController.getAllAppoointments()) {
            System.out.println(app.toString());
        }

    }

    public void cancelAnAppointemnt() {
        System.out.println("Give the ID of the appointment to be deleted:");
        Scanner scannerID = new Scanner(System.in);
        Integer ID = scannerID.nextInt();
        try {
            appointmentController.remove(ID);

        }
        catch ( ConcurrentModificationException concurrentModificationException){{
            System.out.println("There is nothing to be deleted in the list ");
        }};
    }
    public void showAllPatientsCalledJimmy() {
        List<Patient> jimmyList = patientController.getAllPatients().stream().filter(patient -> patient.getFirstName().equals("Jimmy") ).collect(Collectors.toList());
        for (Patient p : jimmyList) {
            System.out.println(p);
        }
    }

    public void showAllAppointmentsWithGreaterIdThan2() {
        List<Appointment> appointmentList = appointmentController.getAllAppoointments().stream().filter(appointment -> appointment.getId() > 2).collect(Collectors.toList());
        for (Appointment a : appointmentList) {
            System.out.println(a);
        }
    }

    public void run() {
        String option = "";
        while (true) {

            showMenu();
            System.out.println("Select the option: ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextLine();
            if (option.equals("1")) {
                addPatient();
            } else if (option.equals("2")) {
                showAllPatients();
            } else if (option.equals("3")) {
                addApointment();
            } else if (option.equals("4")) {
                cancelAnAppointemnt();
            } else if (option.equals("5")) {
                showAllAppointments();
            } else if (option.equals("6")) {
                showTheYoungest();
            } else if (option.equals("7")) {
                showAllPatientsCalledJimmy();
            } else if (option.equals("8")) {
                showAllAppointmentsWithGreaterIdThan2();
            } else if (option.equals("9")) {
                System.out.println("Exit");
                break;
            }
        }
    }


}
