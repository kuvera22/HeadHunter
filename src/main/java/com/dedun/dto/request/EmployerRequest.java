package com.dedun.dto.request;

public class EmployerRequest {
    private String login;
    private String password;
    private String employerName;
    private String firstName;
    private String lastName;
    private String email;

    public EmployerRequest() {
    }

    public EmployerRequest(String login, String password, String employerName, String firstName, String lastName, String email) {
        this.login = login;
        this.password = password;
        this.employerName = employerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getLogin() { return login; }

    public String getPassword() { return password; }

    public String getEmployerName() { return employerName; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getEmail() { return email; }

    public void setLogin(String login) { this.login = login; }

    public void setPassword(String password) { this.password = password; }

    public void setEmployerName(String employerName) { this.employerName = employerName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setEmail(String email) { this.email = email; }
}
