package com.example.hypbank.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.example.hypbank.Models.TransactionRequestResultModel;

public class AlertActivity {

    private final AlertDialog.Builder builder;
    private final Context context;

    public AlertActivity(Context context) {
        this.context = context;
        builder = new AlertDialog.Builder(context);
    }

    public void showAlertDialog() {
        TransactionRequestResultModel requestResultModel = new TransactionRequestResultModel();
        // Authorize Transaction of R PRICE " + "at MERCHANT_NAME
                builder.setTitle("Alert")
                        .setMessage("Are you making a payment?" )
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                performBiometricsAuthentication();
                                requestResultModel.setResponseMessage(true);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestResultModel.setResponseMessage(false);
                                Toast.makeText(context, "Payment Declined", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .create() // Create the AlertDialog instance
                        .show();
    }
    public void performBiometricsAuthentication() {
        BiometricsActivity biometricsActivity = new BiometricsActivity(context);
        biometricsActivity.authenticate();
    }
}
