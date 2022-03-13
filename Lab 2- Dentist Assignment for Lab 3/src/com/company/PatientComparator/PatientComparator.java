package com.company.PatientComparator;

import com.company.Domain.Patient;

import java.util.Comparator;

public  class PatientComparator implements Comparator<Patient> {

    public int compare(Patient p1, Patient p2) {
        return p1.getAge().compareTo(p2.getAge());
    }
}
