package com.example.hypbank.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hypbank.R;

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
          //  sendTransactionRequestResponse();
        }
//        FirebaseMessaging.getInstance().getToken()
//                .addOnCompleteListener(new OnCompleteListener<String>() {
//                    @Override
//                    public void onComplete(@NonNull Task<String> task) {
//                        if (!task.isSuccessful()) {
//                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
//                            return;
//                        }
//                        // Get new FCM registration token
//                        String token = task.getResult();
//                        System.out.println("Token: " + token);
//                    }
//                });

    }
    public void showAlertActivity() {
        AlertActivity alertActivity = new AlertActivity(this);
        alertActivity.showAlertDialog();
    }
}
