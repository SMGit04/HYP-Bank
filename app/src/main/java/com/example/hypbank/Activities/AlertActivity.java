package com.example.hypbank.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertActivity {

    private final AlertDialog.Builder builder;
    private final Context context;

    public AlertActivity(Context context) {
        this.context = context;
        builder = new AlertDialog.Builder(context);
    }

    public void showAlertDialog() {
                builder.setTitle("Alert")
                        .setMessage("Authorize Transaction of R " + "Merchant Name" )
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                performBiometricsAuthentication();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
