package com.example.hypbank.Activities;

import static android.content.ContentValues.TAG;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hypbank.Interfaces.IRetrofitClient;
import com.example.hypbank.Models.TransactionRequestResultModel;
import com.example.hypbank.R;
import com.example.hypbank.Remote.RetrofitClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getExtras() != null) {
            boolean variable = getIntent().getExtras().getBoolean("SHOW_ALERT");
            if (variable) {
                showAlertActivity();
            }
        }
     //   sendTransactionRequestResponse();
    }

    private void sendTransactionRequestResponse() {
        TransactionRequestResultModel requestResultModel = new TransactionRequestResultModel();
        IRetrofitClient retrofitClient = RetrofitClient.getRetrofit().create(IRetrofitClient.class);
        Call<TransactionRequestResultModel> modelCall = retrofitClient.sendAuthenticationResponse(requestResultModel);

        modelCall.enqueue(new Callback<TransactionRequestResultModel>() {
            @Override
            public void onResponse(@NonNull Call<TransactionRequestResultModel> call, @NonNull Response<TransactionRequestResultModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean responseMessage = requestResultModel.getResponseMessage();
                boolean biometricAuthenticated = requestResultModel.isBiometricAuthenticated();
                Toast.makeText(MainActivity.this, responseMessage + "\n" + biometricAuthenticated, Toast.LENGTH_SHORT).show();
                System.out.println(responseMessage + "\n" + biometricAuthenticated);
            }

            @Override
            public void onFailure(@NonNull Call<TransactionRequestResultModel> call, @NonNull Throwable t) {
                Log.d("onFailure: ", Objects.requireNonNull(t.getMessage()));
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showAlertActivity() {
        AlertActivity alertActivity = new AlertActivity(this);
        alertActivity.showAlertDialog();
    }
}
