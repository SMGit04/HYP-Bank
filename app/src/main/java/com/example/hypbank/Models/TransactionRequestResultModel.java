package com.example.hypbank.Models;

import com.google.gson.annotations.SerializedName;

public class TransactionRequestResultModel {
    // Yes or No
    private boolean responseMessage;

    // Biometrics recognised or not
    private boolean biometricAuthenticated;
    @SerializedName("isApproved")
    private boolean isApproved;
    @SerializedName("userID")
    private String userID;

    public TransactionRequestResultModel() {
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setIsApprovedMessage(boolean isApproved) {
        this.isApproved = isApproved;
    }

}
