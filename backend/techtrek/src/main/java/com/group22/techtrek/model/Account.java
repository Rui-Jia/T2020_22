package com.group22.techtrek.model;

import java.util.List;

public class Account {
    private int accountId;
    private String type;
    private String displayName;
    private String accountNumber;
    private double availableBalance;
    private String currency;
    private String dateOfBalance;

    List<Transaction> transactionList;


    /**
     * @return int return the accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * @return String return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
     * @return String return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return double return the availableBalance
     */
    public double getAvailableBalance() {
        return availableBalance;
    }

    /**
     * @param availableBalance the availableBalance to set
     */
    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
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
    public String getDateOfBalance() {
        return dateOfBalance;
    }

    /**
     * @param dateOfBalance the dateOfBalance to set
     */
    public void setDateOfBalance(String dateOfBalance) {
        this.dateOfBalance = dateOfBalance;
    }

    public List<Transaction> getTransactions() {
        return transactionList;
    }

    public void setTransaction(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}