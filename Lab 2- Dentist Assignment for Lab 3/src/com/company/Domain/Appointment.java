package com.company.Domain;
import java.sql.DataTruncation;
import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {
    private Integer id;
    private Integer patientId;
    private String dateAppointemnt;
    public Appointment(){

    }

    public Appointment(Integer id, Integer patientId, String dateAppointemnt) {
        this.id = id;
        this.patientId = patientId;
        this.dateAppointemnt = dateAppointemnt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getDateAppointemnt() {
        return dateAppointemnt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public void setDateAppointemnt(String dateAppointemnt) {
        this.dateAppointemnt = dateAppointemnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id) && Objects.equals(patientId, that.patientId) && Objects.equals(dateAppointemnt, that.dateAppointemnt);
    }

    @Override
    public String toString() {
        return "The appointment has the ID "+ id+ " and the patient has the ID "+ patientId+ " and the appointemnt is established for "+ dateAppointemnt ;
    }
}
