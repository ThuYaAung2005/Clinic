package com.project.clinic.clinic.models;

import jakarta.persistence.*;
@Entity 
@Table(name ="doctor")
public class Doctor  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    private String doctor_name;

    private String doctor_email;

    private String doctor_address;

    private String doctor_phone;

    private String doctor_speciality;

    private String doctor_password;

    public String getDoctor_speciality() {
        return doctor_speciality;
    }

    public void setDoctor_speciality(String doctor_speciality) {
        this.doctor_speciality = doctor_speciality;
    }

    public String getDoctor_password() {
        return doctor_password;
    }

    public void setDoctor_password(String doctor_password) {
        this.doctor_password = doctor_password;
    }

    private String doctor_dob;

    @OneToOne
    @JoinColumn(name = "schedule_id")
    private DcoSchedule dcoSchedule;

    @OneToOne
    @JoinColumn(name="booking_id")
    private Booking booking;

    @OneToOne
    @JoinColumn(name="role_id")
    private Role role;



    public String getDoctor_dob() {
        return doctor_dob;
    }

    public void setDoctorid(Long doctorid) {
        this.doctor_id = doctorid;
    }

    public void setDoctor_dob(String doctor_dob) {
        this.doctor_dob = doctor_dob;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_email() {
        return doctor_email;
    }

    public void setDoctor_email(String doctor_email) {
        this.doctor_email = doctor_email;
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

    public String getDoctor_specialty() {
        return doctor_speciality;
    }

    public void setDoctor_specialty(String doctor_specialty) {
        this.doctor_speciality = doctor_speciality;
    }
}