package com.company.RepositoryImplementation;

import com.company.AbstractRepository.AppointmentRepo;
import com.company.Domain.Appointment;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class RepoAppointmentImplementation implements AppointmentRepo {

    private final List<Appointment> patientRepo = new ArrayList<>();

    @Override
    public void save(Appointment appointment) {
        patientRepo.add(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return patientRepo;
    }

    @Override
    public void remove(Integer appointmentId) throws ConcurrentModificationException {
        for (Appointment app : getAllAppointments()) {
            if (app.getId().equals(appointmentId)) {
                patientRepo.remove(app);
            }
        }
    }
}
