package com.java.abhijitdas.foundation.bank.entity;

public class FundTransfer {

    private Integer fromAccountNumber;
    private Integer toAccountNumber;
    private  Integer amount;

    public FundTransfer() {
    }

    public FundTransfer(Integer fromAccountNumber, Integer toAccountNumber, Integer amount) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
    }

    public Integer getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(Integer toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(Integer fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }
}
