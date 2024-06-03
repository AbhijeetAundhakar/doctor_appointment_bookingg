package com.example.healthcareclientfirebase;

public class appointmentDataModel {
    private String name;
    private String problem;
    private String date;
    private String time;

    public appointmentDataModel(String name, String problem, String date, String time) {
        this.name = name;
        this.problem = problem;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
