package com.dedun.dto.response;

import java.time.LocalDate;

public class VacanciesResponse {
    private Integer id;
    private String city;
    private int salary;
    private Integer workExperience;
    private LocalDate dateOfPlacement;
    private String status;
    EmployerResponse employerResponse;

    public VacanciesResponse() {
    }

    public VacanciesResponse(Integer id, String city, int salary, Integer workExperience, LocalDate dateOfPlacement, String status, EmployerResponse employerResponse) {
        this.id = id;
        this.city = city;
        this.salary = salary;
        this.workExperience = workExperience;
        this.dateOfPlacement = dateOfPlacement;
        this.status = status;
        this.employerResponse = employerResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public EmployerResponse getEmployerResponse() {
        return employerResponse;
    }

    public void setEmployerResponse(EmployerResponse employerResponse) {
        this.employerResponse = employerResponse;
    }
}
