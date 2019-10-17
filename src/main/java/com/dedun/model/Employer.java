package com.dedun.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String employerName;
    private String firstName;
    private String lastName;
    private String email;

  @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="employer")
   public List<Vacancies> vacancies;

    public Employer() {
    }

    public Employer(String login, String password, String employerName, String firstName, String lastName, String email) {
        this.login = login;
        this.password = password;
        this.employerName = employerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return Objects.equals(getId(), employer.getId()) &&
                Objects.equals(getLogin(), employer.getLogin()) &&
                Objects.equals(getPassword(), employer.getPassword()) &&
                Objects.equals(getEmployerName(), employer.getEmployerName()) &&
                Objects.equals(getFirstName(), employer.getFirstName()) &&
                Objects.equals(getLastName(), employer.getLastName()) &&
                Objects.equals(getEmail(), employer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getEmployerName(), getFirstName(), getLastName(), getEmail());
    }
}
