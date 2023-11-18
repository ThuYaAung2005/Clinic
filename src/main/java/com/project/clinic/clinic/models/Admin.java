package com.project.clinic.clinic.models;

import jakarta.persistence.*;
@Entity
@Table(name="admin")
public class Admin  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long admin_id;
        private String admin_name;
        private String admin_email;
        private String admin_phoneno;
        private String admin_password;
        public Admin(Long admin_id, String admin_name, String admin_email, String admin_phoneno, String admin_password) {
            this.admin_id = admin_id;
            this.admin_name = admin_name;
            this.admin_email = admin_email;
            this.admin_phoneno = admin_phoneno;
            this.admin_password = admin_password;
        }

        public Admin(String  admin_email, String admin_password) {
            this.admin_email = admin_email;
            this.admin_password = admin_password;
        }

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

        public String getAdmin_email() {
            return admin_email;
        }

        public void setAdmin_email(String admin_email) {
            this.admin_email = admin_email;
        }

        public String getAdmin_phoneno() {
            return admin_phoneno;
        }

        public void setAdmin_phoneno(String admin_phoneno) {
            this.admin_phoneno = admin_phoneno;
        }

        public String getAdmin_password() {
            return admin_password;
        }

        public void setAdmin_password(String admin_password) {
            this.admin_password = admin_password;
        }
    }
