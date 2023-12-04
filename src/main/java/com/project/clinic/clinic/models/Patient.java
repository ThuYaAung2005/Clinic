package com.project.clinic.clinic.models;

import jakarta.persistence.*;

@Entity
@Table(name="patient")
public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private  Long patient_id;

        private String patient_name;

        private String patient_email;

        private String patient_address;

        private String patient_phone;

        private String patient_dob;

        private String patient_age;

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPatient_password() {
        return patient_password;
    }

    public void setPatient_password(String patient_password) {
        this.patient_password = patient_password;
    }

    private String patient_password;

        private String patient_gender;

        @ManyToOne
        @JoinColumn(name = "booking_id")
        private Booking booking;



    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
            return patient_name;
        }

        public void setPatient_name(String patient_name) {
            this.patient_name = patient_name;
        }

        public String getPatient_address() {
            return patient_address;
        }

        public void setPatient_address(String patient_address) {
            this.patient_address = patient_address;
        }

        public String getPatient_phone() {
            return patient_phone;
        }

        public void setPatient_phone(String patient_phone) {
            this.patient_phone = patient_phone;
        }

        public String getPatient_dob() {
            return patient_dob;
        }

        public void setPatient_dob(String patient_dob) {
            this.patient_dob = patient_dob;
        }

        public String getPatient_age() {
            return patient_age;
        }

        public void setPatient_age(String patient_age) {
            this.patient_age = patient_age;
        }

        public String getPatient_gender() {
            return patient_gender;
        }

        public void setPatient_gender(String patient_gender) {
            this.patient_gender = patient_gender;
        }
}

