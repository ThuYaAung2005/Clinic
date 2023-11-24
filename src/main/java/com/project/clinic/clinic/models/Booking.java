package com.project.clinic.clinic.models;

import jakarta.persistence.*;

import javax.print.Doc;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_id;

    private String booking_time;

    private String booking_date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patiend_name")
    private Patient patient_name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "docotor_id")
    private Doctor doctor;

    public Long getBookingid() {
        return booking_id;
    }

    public void setBookingid(Long booking_id) {
        this.booking_id = booking_id;
    }

    public String getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(String booking_time) {
        this.booking_time = booking_time;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }


}

