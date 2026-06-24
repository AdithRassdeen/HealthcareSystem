package com.healthcare.model;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String date;
    private String time;

    // Constructor
    public Appointment(int appointmentId, int patientId, int doctorId, String date, String time) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    // Getters and Setters
    public int getAppointmentId() { return appointmentId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public String getTime() { return time; }
}
