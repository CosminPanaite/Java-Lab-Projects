package com.company.AbstractRepository;

import com.company.Domain.Patient;

import java.util.List;

public interface PatientRepo {
    void save(Patient patient);
    List<Patient> getAllPatients();

}
