package com.company.AbstractController;

import com.company.Domain.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentController {
    void save(Integer id, Integer idAppointment, String date);
    void remove(Integer id);
    List<Appointment>getAllAppoointments();
}
