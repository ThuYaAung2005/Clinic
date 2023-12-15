package com.project.clinic.clinic.models;

import jakarta.persistence.*;
@Entity
@Table(name = "schedule")
public class DocSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long schedule_id;

    private String day;

    private String start_time;

    private String end_time;


//    @OneToOne
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;

    public Long getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Long schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
}
