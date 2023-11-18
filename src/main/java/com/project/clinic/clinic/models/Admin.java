package com.project.clinic.clinic.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
@Entity
public class Admin  {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int admin_id;
        private String admin_name, admin_email,admin_phoneno, admin_password;

        public Admin(int admin_id, String admin_name, String admin_email, String admin_phoneno, String admin_password) {
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

        public int getAdmin_id() {
            return admin_id;
        }

        public void setAdmin_id(int admin_id) {
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
