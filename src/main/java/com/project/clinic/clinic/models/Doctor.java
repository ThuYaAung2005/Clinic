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
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String cost;

    @NotNull
    private String phone;

    @NotNull
    private String speciality;

    @NotNull
    private String password;

    private String roles;

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @PrePersist
    private void validate(){

        if ( name == null || name.isEmpty()) {
            throw new IllegalStateException("Doctorname cannot be empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalStateException("Password cannot be empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalStateException("Email cannot be empty");
        }
        if (cost == null || cost.isEmpty()) {
            throw new IllegalStateException("Full name cannot be empty");
        }
        if (phone== null || phone.isEmpty()) {
            throw new IllegalStateException("Full name cannot be empty");
        }
        if (speciality== null || speciality.isEmpty()) {
            throw new IllegalStateException("Full name cannot be empty");
        }
    }
}