package com.dedun.dto.response;

public class EmployerResponse {
    private int id;
    private String login;
    private String employerName;
    private String firstName;
    private String lastName;
    private String email;

    public EmployerResponse() {
    }

    public EmployerResponse(int id, String login, String employerName, String firstName, String lastName, String email) {
        this.id = id;
        this.login = login;
        this.employerName = employerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}
