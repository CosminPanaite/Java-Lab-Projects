package com.company.Controller;

import com.company.Domain.Appointment;
import com.company.repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentController {
    private final AppointmentRepository repo;

    public AppointmentController(AppointmentRepository repo) {
        this.repo = repo;
    }


    public void addObject(Appointment appointment) {
        repo.add(appointment);
    }

    public void deleteObject(Appointment appointment) {
        repo.delete(appointment);
    }

    public void updateObject(Appointment appointment) {
        repo.update(appointment, appointment.getID());
    }

    public void searchObject(Appointment appointment) {
        repo.findById(appointment.getID());
    }

    public Iterable<Appointment> controllerFindAll() {
        return repo.findAll();
    }

    public Collection<Appointment> controllerGetAll() {
        return repo.getAll();
    }

    //Filters functions
    public List<Appointment> getAppointemntWithIdGreaterThanFour() {
        Collection<Appointment> appointmentCollection = controllerGetAll();
        List<Appointment> appointmentList = appointmentCollection.stream().filter(appointment -> appointment.getID() > 4).collect(Collectors.toList());
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            result.add(appointment);
        }
        return result;
    }

    public List<Integer> getIdOfAppointmentsAppointmentsFrom2021() {
        Collection<Appointment> appointmentCollection = controllerGetAll();
        List<Appointment> appointmentList = appointmentCollection.stream().filter(appointment -> appointment.getDateAppointemnt().endsWith("2021")).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            result.add(appointment.getID());
        }
        return result;
    }
}
