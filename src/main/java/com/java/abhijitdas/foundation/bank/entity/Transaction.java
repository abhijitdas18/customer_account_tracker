package com.java.abhijitdas.foundation.bank.entity;

import java.util.Date;

public class Transaction {

    private Integer transactionId;
    private  Integer transactionAmount;
    private String dateTime;
    private String message;

    public Integer getTransactionId() {
        return transactionId;
    }

    public Transaction(Integer transactionId, Integer transactionAmount, String dateTimeString, String message) {
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.dateTime = dateTimeString;
        this.message = message;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Integer transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
