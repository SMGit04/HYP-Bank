package com.example.hypbank.Activities;

import static android.content.ContentValues.TAG;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hypbank.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    ImageButton alertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertButton = findViewById(R.id.makePaymentButton);

        if (getIntent().getExtras() != null) {
            Boolean variable = getIntent().getExtras().getBoolean("SHOW_ALERT");
            if (variable) {
                showAlertActivity();
            }
        }
    }

    public void showAlertActivity() {
        AlertActivity alertActivity = new AlertActivity(this);
        alertActivity.showAlertDialog();
    }
}
