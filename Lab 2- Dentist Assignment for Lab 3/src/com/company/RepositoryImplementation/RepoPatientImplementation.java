package com.company.RepositoryImplementation;

import com.company.AbstractRepository.PatientRepo;
import com.company.Domain.Patient;

import java.util.ArrayList;
import java.util.List;

public class RepoPatientImplementation implements PatientRepo {
    private final List<Patient>patientsRepo=new ArrayList<>();
    @Override
    public void save(Patient patient) {
        patientsRepo.add(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientsRepo;
    }

}
