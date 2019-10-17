package com.dedun.dto.response;

import java.time.LocalDate;

public class SummaryResponse {
    private Integer id;
    private String mobilePhone;
    private String city;
    private LocalDate dateOfBirth;
    private String sex;
    private Integer workExperience;
    private String educationalInstitution;
    private int desiredSalary;
    private WorkerResponse workerResponse;

    public SummaryResponse() {
    }

    public SummaryResponse(Integer id, String mobilePhone, String city, LocalDate dateOfBirth, String sex, Integer workExperience, String educationalInstitution, int desiredSalary, WorkerResponse workerResponse) {
        this.id = id;
        this.mobilePhone = mobilePhone;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.workExperience = workExperience;
        this.educationalInstitution = educationalInstitution;
        this.desiredSalary = desiredSalary;
        this.workerResponse = workerResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public int getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(int desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public WorkerResponse getWorkerResponse() {
        return workerResponse;
    }

    public void setWorkerResponse(WorkerResponse workerResponse) {
        this.workerResponse = workerResponse;
    }
}
