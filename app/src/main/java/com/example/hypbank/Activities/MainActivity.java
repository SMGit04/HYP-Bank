package com.example.hypbank.Activities;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.hypbank.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView data;
    private CoordinatorLayout mainLayout;
    ImageButton closeButton;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        System.out.println("Token: " + token);
                        Log.d(TAG, token);
                        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

        closeButton = findViewById(R.id.makePaymentButton);
        // data = findViewById(R.id.data);

        mainLayout = findViewById(R.id.main_layout);

        // baseUrl = "http://10.0.2.2:5174/api/CardValidator?cardNumber=4847954048973513";

        AlertActivity alertActivity = new AlertActivity(this, closeButton);
        alertActivity.showAlertDialog();

/*        ApiService apiService = new ApiService(this, data);
        apiService.performApiCall(baseUrl);*/

        // TODO: Call RetrofitClient class to perform API call


    }

}
