package com.example.hypbank.Interfaces;

import com.example.hypbank.Models.TransactionRequestResultModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IRetrofitClient {
@GET("/api/Notification/authorizationResponse")
    Call<TransactionRequestResultModel> sendAuthenticationResponse(@Body TransactionRequestResultModel requestResultModel);
}
