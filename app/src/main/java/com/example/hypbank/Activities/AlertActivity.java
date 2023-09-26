package com.example.hypbank.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

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
                builder.setTitle("Alert")
                        .setMessage("Authorize Transaction of R PRICE " + "at MERCHANT_NAME" )
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
