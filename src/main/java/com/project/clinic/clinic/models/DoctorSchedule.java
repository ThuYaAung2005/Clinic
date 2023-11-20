package com.project.clinic.clinic.models;

public class DoctorSchedule {
    private Long scheduleid;
    private String stattime;
    private String endtime;

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
