package com.project.clinic.clinic.models;

import jakarta.persistence.*;
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bil_id;

    private String bill_result ;

    private String bill_time;
    private String bill_day;

    @OneToOne
    @JoinColumn(name ="booking_id" )
    private Booking booking;


    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


}
