package com.example.hypbank.Models;

public class TransactionRequestResultModel {

    private boolean responseMessage; // Yes or No
    private  boolean biometricAuthenticated; // Biometrics recognised or not

    public TransactionRequestResultModel() {
    }

    public TransactionRequestResultModel(boolean responseMessage, boolean biometricAuthenticated) {
        this.responseMessage = responseMessage;
        this.biometricAuthenticated = biometricAuthenticated;
    }

    public boolean getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(boolean responseMessage) {
        this.responseMessage = responseMessage;
    }

    public boolean isBiometricAuthenticated() {
        return biometricAuthenticated;
    }

    public void setBiometricAuthenticated(boolean biometricAuthenticated) {
        this.biometricAuthenticated = biometricAuthenticated;
    }
}
