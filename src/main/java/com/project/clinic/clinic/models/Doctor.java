package com.project.clinic.clinic.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Doctor  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int doctorid;
        private String docname, docdob, docaddress, docphoneno,docspecialty;


        public int getDoctorid() {
            return doctorid;
        }

        public void setDoctorid(int doctorid) {
            this.doctorid = doctorid;
        }

        public String getDocname() {
            return docname;
        }

        public void setDocname(String docname) {
            this.docname = docname;
        }

        public String getDocdob() {
            return docdob;
        }

        public void setDocdob(String docdob) {
            this.docdob = docdob;
        }

        public String getDocaddress() {
            return docaddress;
        }

        public void setDocaddress(String docaddress) {
            this.docaddress = docaddress;
        }

        public String getDocphoneno() {
            return docphoneno;
        }

        public void setDocphoneno(String docphoneno) {
            this.docphoneno = docphoneno;
        }


        public String getDocspecialty() {
            return docspecialty;
        }

        public void setDocspecialty(String docspecialty) {
            this.docspecialty = docspecialty;
        }
    }

