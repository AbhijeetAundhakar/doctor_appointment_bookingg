package com.example.healthcareclientfirebase;

public class Booking {
    private long id; // Add ID field
    private String firstName;
    private String lastName;
    private String problemDescription;
    private String date;
    private String dateButton;
    private String timeButton;
    private String bookingId;
    private String userId;

    public Booking() {
    }
    public Booking(String bookingId, String userId,String firstName, String lastName, String problemDescription, String date, String dateButton, String timeButton) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.problemDescription = problemDescription;
        this.date = date;
        this.dateButton = dateButton;
        this.timeButton = timeButton;
    }

    // Getters and setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDateButton() {
        return dateButton;
    }

    public void setDateButton(String dateButton) {
        this.dateButton = dateButton;
    }

    public String getTimeButton() {
        return timeButton;
    }

    public void setTimeButton(String timeButton) {
        this.timeButton = timeButton;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public String getDate() {
        return date;
    }

    // Add a getter method for ID
    public long getId() {
        return id;
    }

    // Add a setter method for ID if needed
    public void setId(long id) {
        this.id = id;
    }

}
