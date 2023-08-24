package com.example.hypbank.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AlertActivity {

    private final AlertDialog.Builder builder;
    private final Context context;
    private final ImageButton closeButton;

    public AlertActivity(Context context, ImageButton closeButton) {
        this.context = context;
        this.closeButton = closeButton;
        builder = new AlertDialog.Builder(context);
    }

    public void showAlertDialog() {
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
    }
    public void performBiometricsAuthentication() {
        BiometricsActivity biometricsActivity = new BiometricsActivity(context);
        biometricsActivity.authenticate();
    }
}
