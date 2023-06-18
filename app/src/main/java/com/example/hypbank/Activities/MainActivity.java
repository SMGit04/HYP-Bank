package com.example.hypbank.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.hypbank.R;
import com.example.hypbank.Services.ApiService;

public class MainActivity extends AppCompatActivity {
    private TextView data;
    private CoordinatorLayout mainLayout;
    ImageButton closeButton;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        closeButton = findViewById(R.id.makePaymentButton);
        // data = findViewById(R.id.data);

        mainLayout = findViewById(R.id.main_layout);

        baseUrl = "http://10.0.2.2:5174/api/CardValidator?cardNumber=4847954048973513";

        AlertActivity alertActivity = new AlertActivity(this, closeButton);
        alertActivity.showAlertDialog();

/*        ApiService apiService = new ApiService(this, data);
        apiService.performApiCall(baseUrl);*/
    }
}
