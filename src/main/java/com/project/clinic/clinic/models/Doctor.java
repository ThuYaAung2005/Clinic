package com.project.clinic.clinic.models;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name ="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long doctor_id;

    @NotNull
    private String doctor_name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String doctor_address;

    @NotNull
    private String doctor_phone;

    @NotNull
    private String doctor_speciality;

    @NotNull
    private String password;

    private String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @PrePersist
    private void validate(){

        if ( doctor_name == null || doctor_name.isEmpty()) {
            throw new IllegalStateException("Doctorname cannot be empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalStateException("Password cannot be empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalStateException("Email cannot be empty");
        }
        if (doctor_address == null || doctor_address.isEmpty()) {
            throw new IllegalStateException("Full name cannot be empty");
        }
        if (doctor_phone== null || doctor_phone.isEmpty()) {
            throw new IllegalStateException("Full name cannot be empty");
        }
        if (doctor_speciality== null || doctor_speciality.isEmpty()) {
            throw new IllegalStateException("Full name cannot be empty");
        }

    }
}