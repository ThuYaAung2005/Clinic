package com.project.clinic.clinic.models;

import jakarta.persistence.*;

@Entity
public class PatientHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long health_id;

    @Column(length = 999999999)
    private String patient_disease;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public long getHealth_id() {
        return health_id;
    }

    public void setHealth_id(long health_id) {
        this.health_id = health_id;
    }

    public String getPatient_disease() {
        return patient_disease;
    }

    public void setPatient_disease(String patient_disease) {
        this.patient_disease = patient_disease;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

