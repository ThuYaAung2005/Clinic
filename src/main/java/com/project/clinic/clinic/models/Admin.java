package com.project.clinic.clinic.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="admin")
public class Admin  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long admin_id;

        private String admin_name;

        private String admin_phone;

        private String admin_email;

        private String admin_password;



//        @OneToMany(mappedBy = "admin")
//        private List<Patient> patients;
//
//        @OneToMany(mappedBy = "doctoradmin")
//        private List<Doctor>  doctors;

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
            return admin_name;
        }

        public void setAdmin_name(String admin_name) {
            this.admin_name = admin_name;
        }

        public String getAdmin_phone() {
            return admin_phone;
        }

        public void setAdmin_phone(String admin_phone) {
            this.admin_phone = admin_phone;
        }

    }
