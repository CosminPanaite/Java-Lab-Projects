package com.company.ControllerImplementation;

import com.company.AbstractController.PatientController;
import com.company.AbstractRepository.PatientRepo;
import com.company.Domain.Patient;
import com.company.RepositoryImplementation.RepoPatientImplementation;

import java.util.List;

public class PatientControllerImplementation implements PatientController {
    private PatientRepo patientRepo;
    public PatientControllerImplementation(PatientRepo patientRepo){
        this.patientRepo=patientRepo;

    }
    @Override
    public void save(Integer id, String firstName, String lastName, Integer age, String problem) {
        Patient patient=new Patient(id,firstName,lastName,age,problem);
        patientRepo.save(patient);

    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.getAllPatients();
    }
}
