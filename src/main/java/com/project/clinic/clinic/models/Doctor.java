package com.project.clinic.clinic.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name ="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    private String doctor_name;

    private String email;

    private String doctor_address;

    private String doctor_phone;

    private String doctor_speciality;

    private String password;

    @OneToOne
    @JoinColumn(name = "schedule_id")
    private DocSchedule docSchedule;

    @OneToMany
    @JoinColumn(name = "booking_id")
    private List<Booking> bookings;

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id)  {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_email() {
        return email;
    }

    public void setDoctor_email(String doctor_email) {
        this.email = doctor_email;
    }

    public String getDoctor_address() {
        return doctor_address;
    }

    public void setDoctor_address(String doctor_address) {
        this.doctor_address = doctor_address;
    }

    public String getDoctor_phone() {
        return doctor_phone;
    }

    public void setDoctor_phone(String doctor_phone) {
        this.doctor_phone = doctor_phone;
    }

    public String getDoctor_speciality() {
        return doctor_speciality;
    }

    public void setDoctor_speciality(String doctor_speciality) {
        this.doctor_speciality = doctor_speciality;
    }

    public String getDoctor_password() {
        return password;
    }
    public void setDoctor_password(String doctor_password) {
        this.password = doctor_password;
    }
}
