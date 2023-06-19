package com.example.hypbank.Models;

public class UserModel {
private String name;
    private String surname;
    private String cardNumber;
    private String expiryDate;
    private String accountNumber;
    private String cvv;

    public UserModel(String name, String surname, String cardNumber, String expiryDate, String accountNumber, String cvv) {
        this.name = name;
        this.surname = surname;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.accountNumber = accountNumber;
        this.cvv = cvv;
    }

    public UserModel() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCvv() {
        return cvv;
    }

}
