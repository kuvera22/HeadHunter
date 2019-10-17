package com.dedun.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vacancies")
public class Vacancies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private int salary;
    private Integer workExperience;
    private LocalDate dateOfPlacement;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employer employer;

    public Vacancies() {
    }

    public Vacancies(String city, int salary, Integer workExperience, LocalDate dateOfPlacement, String status, Employer employer) {
        this.city = city;
        this.salary = salary;
        this.workExperience = workExperience;
        this.dateOfPlacement = dateOfPlacement;
        this.status = status;
        this.employer = employer;
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

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacancies)) return false;
        Vacancies vacancies = (Vacancies) o;
        return getSalary() == vacancies.getSalary() &&
                Objects.equals(getId(), vacancies.getId()) &&
                Objects.equals(getCity(), vacancies.getCity()) &&
                Objects.equals(getWorkExperience(), vacancies.getWorkExperience()) &&
                Objects.equals(getDateOfPlacement(), vacancies.getDateOfPlacement()) &&
                Objects.equals(getStatus(), vacancies.getStatus()) &&
                Objects.equals(getEmployer(), vacancies.getEmployer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCity(), getSalary(), getWorkExperience(), getDateOfPlacement(), getStatus(), getEmployer());
    }
}
