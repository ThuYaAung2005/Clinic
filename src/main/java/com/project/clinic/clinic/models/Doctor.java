package com.project.clinic.clinic.models;

import jakarta.persistence.*;

@Entity
@Table(name ="doctor")
public class Doctor  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long doctorid;

        private String docname;

        private String docdob;

        private String docaddress;

        private String docphoneno;

        private String docspecialty;

    public Long getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Long doctorid) {
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

