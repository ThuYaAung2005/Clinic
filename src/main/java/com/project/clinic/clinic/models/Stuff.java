package com.project.clinic.clinic.models;

import jakarta.persistence.*;
import jdk.jfr.Name;

@Entity
@Table(name ="stuff")
public class Stuff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stuff_id;

    private String name;

    private String phone;

    private String email;

    private String salary;
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private String image;

    private String password;

    public long getStuff_id() {
        return stuff_id;
    }

    public void setStuff_id(long stuff_id) {
        this.stuff_id = stuff_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

