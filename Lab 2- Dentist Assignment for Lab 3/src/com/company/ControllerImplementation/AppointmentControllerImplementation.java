package com.company.ControllerImplementation;

import com.company.AbstractController.AppointmentController;
import com.company.AbstractController.PatientController;
import com.company.AbstractRepository.AppointmentRepo;
import com.company.AbstractRepository.PatientRepo;
import com.company.Domain.Appointment;
import com.company.RepositoryImplementation.RepoAppointmentImplementation;

import java.time.LocalDateTime;
import java.util.ConcurrentModificationException;
import java.util.List;

public class AppointmentControllerImplementation implements AppointmentController {
    private AppointmentRepo appointmentRepo;

    public AppointmentControllerImplementation(AppointmentRepo appointmentRepo){
        this.appointmentRepo=appointmentRepo;
    }
    @Override
    public void save(Integer id, Integer idAppointment, String date) {
        Appointment appointment=new Appointment(id,idAppointment, date);
        appointmentRepo.save(appointment);
    }

    @Override
    public void remove(Integer id) throws ConcurrentModificationException {
        appointmentRepo.remove(id);
    }

    @Override
    public List<Appointment> getAllAppoointments() {
        return appointmentRepo.getAllAppointments();
    }
}
