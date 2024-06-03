package com.example.healthcareclientfirebase;

public class user {
    String email;
    String licenceNumber;
    String name;
    String nameOfHospital;
    String specility;
    String yearsOfExperience;

    user() {

    }

    public user(String email, String licenceNumber, String name, String nameOfHospital, String specility, String yearsOfExperience) {
        this.email = email;
        this.licenceNumber = licenceNumber;
        this.name = name;
        this.nameOfHospital = nameOfHospital;
        this.specility = specility;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfHospital() {
        return nameOfHospital;
    }

    public void setNameOfHospital(String nameOfHospital) {
        this.nameOfHospital = nameOfHospital;
    }

    public String getSpecility() {
        return specility;
    }

    public void setSpecility(String specility) {
        this.specility = specility;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }


}
