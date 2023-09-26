package com.example.hypbank.Interfaces;

import com.example.hypbank.Models.TransactionRequestResultModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IRetrofitClient {

@POST("")
    Call<TransactionRequestResultModel> sendAuthenticationResponse(@Body TransactionRequestResultModel requestResultModel);
}
