package com.group22.techtrek.model;

import java.util.List;

public class User {
    private int customerId;
    private String userName;
    private String password;
    private String gender;
    private String firstName;
    private String lastName;
    private String lastLogin;
    private String dateOfBirth;
    private String riskLevel;
    List<Account> accountList;
  
    

    @Override
    public String toString() {
        return customerId + " " + userName + " " + password + " " + gender;
    }

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
     * @return String return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
    public String getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return LocalDateTime return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
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
    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(List<Account> accountList) {
        this.accountList = accountList;
    }

}