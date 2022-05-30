package com.example.safetytravel;

public class register_data {

    private String username;
    private String email;
    private String password;
    private String selectedRadio;

    public register_data(){}
    public register_data(String username, String email, String password, String selectedRadio) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.selectedRadio = selectedRadio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSelectedRadio() {
        return selectedRadio;
    }

    public void setSelectedRadio(String selectedRadio) {
        this.selectedRadio = selectedRadio;
    }
}
