package com.sparta.jka.logic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

    private String empID;
    private String prefixName;
    private String firstName;
    private String lastName;
    private String middleInit;
    private String gender;
    private String email;
    private LocalDate dob;
    private LocalDate dateOfJoining;
    private double salary;

    public Employee(String empID, String prefixName, String firstName, String middleInit, String lastName, String gender,
                    String email, LocalDate dob, LocalDate dateOfJoining, double salary) {
        this.empID = empID;
        this.prefixName = prefixName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInit = middleInit;
        this.gender = gender;
        this.email = email;
        this.dob = dateOfJoining;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;

    }


    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInit() {
        return middleInit;
    }

    public void setMiddleInit(String middleInit) {
        this.middleInit = middleInit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
