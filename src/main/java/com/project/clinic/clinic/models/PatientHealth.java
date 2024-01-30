package com.project.clinic.clinic.models;

import jakarta.persistence.*;

@Entity
public class PatientHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long health_id;

    @Column(length = 999999999)
    private String disease;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

//    public String date;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

    public long getHealth_id() {
        return health_id;
    }

    public void setHealth_id(long health_id) {
        this.health_id = health_id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

