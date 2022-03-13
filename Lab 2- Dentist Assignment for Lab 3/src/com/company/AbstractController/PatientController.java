package com.company.AbstractController;

import com.company.Domain.Patient;

import java.util.List;

public interface PatientController {
    void save(Integer id,String firstName, String lastName, Integer age, String problem);
    List<Patient> getAllPatients();

}
