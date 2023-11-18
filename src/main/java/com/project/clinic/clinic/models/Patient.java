package com.project.clinic.clinic.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  int patient_id;
        private String patient_name, patient_address, patient_phoneno, patient_dob, patient_age, patient_gender;

        public int getPatient_id() {
            return patient_id;
        }

        public void setPatient_id(int patient_id) {
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

        public String getPatient_phoneno() {
            return patient_phoneno;
        }

        public void setPatient_phoneno(String patient_phoneno) {
            this.patient_phoneno = patient_phoneno;
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

