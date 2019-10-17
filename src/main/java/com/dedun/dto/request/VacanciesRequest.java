package com.dedun.dto.request;

import java.time.LocalDate;

public class VacanciesRequest {
    private String city;
    private int salary;
    private Integer workExperience;
    private LocalDate dateOfPlacement;
    private String status;

    public VacanciesRequest() {
    }

    public VacanciesRequest(String city, int salary, Integer workExperience, LocalDate dateOfPlacement, String status) {
        this.city = city;
        this.salary = salary;
        this.workExperience = workExperience;
        this.dateOfPlacement = dateOfPlacement;
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public LocalDate getDateOfPlacement() {
        return dateOfPlacement;
    }

    public void setDateOfPlacement(LocalDate dateOfPlacement) {
        this.dateOfPlacement = dateOfPlacement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
