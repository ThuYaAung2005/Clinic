package com.project.clinic.clinic.models;

import jakarta.persistence.*;

@Entity
public class PatientHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long health_id;

    private String patient_disease;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}

