package com.company.AbstractRepository;

import com.company.Domain.Appointment;

import java.util.List;

public interface AppointmentRepo {
    void save(Appointment appointment);
    List<Appointment> getAllAppointments();
    void remove(Integer appointmentId);
}
