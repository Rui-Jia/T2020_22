package com.group22.techtrek.model;

import java.time.LocalDateTime;
import java.util.List;

public class Account {
    private int accId;
    private String accType;
    private String displayName;
    private String accNumber;
    private double balance;
    private String currency;
    private LocalDateTime dateOfBalance;
    List<Transaction> transactionList;
 
    /**
     * @return int return the accId
     */
    public int getAccId() {
        return accId;
    }

    /**
     * @param accId the accId to set
     */
    public void setAccId(int accId) {
        this.accId = accId;
    }

    /**
     * @return String return the accType
     */
    public String getAccType() {
        return accType;
    }

    /**
     * @param accType the accType to set
     */
    public void setAccType(String accType) {
        this.accType = accType;
    }

    /**
     * @return String return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return String return the accNumber
     */
    public String getAccNumber() {
        return accNumber;
    }

    /**
     * @param accNumber the accNumber to set
     */
    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    /**
     * @return double return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return String return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return LocalDateTime return the dateOfBalance
     */
    public LocalDateTime getDateOfBalance() {
        return dateOfBalance;
    }

    /**
     * @param dateOfBalance the dateOfBalance to set
     */
    public void setDateOfBalance(LocalDateTime dateOfBalance) {
        this.dateOfBalance = dateOfBalance;
    }

    public List<Transaction> getTransactions() {
        return transactionList;
    }

    public void setTransaction(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}