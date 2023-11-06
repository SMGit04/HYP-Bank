package com.example.hypbank.Services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.hypbank.Interfaces.IRetrofitClient;
import com.example.hypbank.Models.TransactionRequestResultModel;
import com.example.hypbank.Remote.RetrofitClient;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponseService {
    Context context;

    public void sendTransactionRequestResponse(boolean alertResponse, boolean biometricResponse) {
        TransactionRequestResultModel requestResultModel = new TransactionRequestResultModel();
        requestResultModel.setUserID("4301049898686098");   // Manually set ID for simplicity

        IRetrofitClient retrofitClient = RetrofitClient.getRetrofit().create(IRetrofitClient.class);
        Call<TransactionRequestResultModel> modelCall = retrofitClient.sendAuthenticationResponse(requestResultModel);


        if (!alertResponse) {
            requestResultModel.setIsApprovedMessage(false);
        } else requestResultModel.setIsApprovedMessage(biometricResponse);
        modelCall.enqueue(new Callback<TransactionRequestResultModel>() {
            @Override
            public void onResponse(@NonNull Call<TransactionRequestResultModel> call, @NonNull Response<TransactionRequestResultModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "Failed respond", Toast.LENGTH_SHORT).show();
                    System.out.println("Failed respond");
                    return;
                }
            }

            @Override
            public void onFailure(@NonNull Call<TransactionRequestResultModel> call, @NonNull Throwable t) {
                Log.d("onFailure: ", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}
