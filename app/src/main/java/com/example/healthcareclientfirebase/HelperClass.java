package com.example.healthcareclientfirebase;

public class HelperClass {
    String name, email, yearsOfExperience, nameOfHospital, specility, licenceNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
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

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public HelperClass(String name, String email, String yearsOfExperience, String nameOfHospital, String specility, String licenceNumber) {
        this.name = name;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
        this.nameOfHospital = nameOfHospital;
        this.specility = specility;
        this.licenceNumber = licenceNumber;
    }

    public HelperClass() {
    }
}
