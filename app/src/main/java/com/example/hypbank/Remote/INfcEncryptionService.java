package com.example.hypbank.Remote;

import android.database.Observable;

import com.example.hypbank.Models.UserModel;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface INfcEncryptionService {

    // https://localhost:7126/api/Encryption
    // https://localhost:7126/api/ApproveOrDeclineTransaction
    @POST("")
    Observable<String> registerUser(@Body UserModel userModel);

    @POST("")
    Observable<String> loginUser(@Body UserModel userModel);
}
