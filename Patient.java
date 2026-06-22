package com.healthcare.model;

public class Patient extends Person {
    private int age;
    private String gender;

    public Patient(String name, int age, String gender, String phone) {
        super(name, phone); 
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    @Override
    public void printDetails() {
        System.out.println("Patient Name: " + getName() + " | Age: " + getAge() + " | Gender: " + getGender());
    }
}
