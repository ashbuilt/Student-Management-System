package com.studentapp;

public class Student {

    private int id;
    private String name;
    private String branch;
    private double cgpa;

    // 🔹 No-argument constructor
    public Student() {
    }

    // 🔹 Constructor without id (for INSERT)
    public Student(String name, String branch, double cgpa) {
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    // 🔹 Getter & Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 🔹 Getter & Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 🔹 Getter & Setter for branch
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    // 🔹 Getter & Setter for cgpa
    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
