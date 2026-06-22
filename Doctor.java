package com.healthcare.model;

public class Doctor extends Person {
    private String specialization;

    public Doctor(String name, String phone, String specialization) {
        super(name, phone);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
    @Override
    public void printDetails() {
        System.out.println("Doctor Name: " + getName() + " | Specialization: " + specialization);
    }
}

