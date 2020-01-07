package com.group22.techtrek.model;

import java.time.LocalDateTime;

public class User {
    private int customerId;
    private String username;
    private String password;
    private String gender;
    private String firstName;
    private String lastName;
    private LocalDateTime lastLogin;
    private LocalDateTime dateOfBirth;
    private String riskLevel;
    private Account account;
    

    /**
     * @return int return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return LocalDateTime return the lastLogin
     */
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return LocalDateTime return the dateOfBirth
     */
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return String return the riskLevel
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * @param riskLevel the riskLevel to set
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }


    /**
     * @return Account return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

}