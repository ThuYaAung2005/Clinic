package com.project.clinic.clinic.models;

import jakarta.persistence.*;
@Entity
@Table(name = "schedule")
public class DoctorSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleid;

    private String stattime;

    private String endtime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Long scheduleid) {
        this.scheduleid = scheduleid;
    }

    public String getStattime() {
        return stattime;
    }

    public void setStattime(String stattime) {
        this.stattime = stattime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
