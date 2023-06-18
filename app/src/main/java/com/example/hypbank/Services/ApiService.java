package com.example.hypbank.Services;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;

public class ApiService {
    private final Context context;
    private final TextView data;

    public ApiService(Context context, TextView data) {
        this.context = context;
        this.data = data;
    }

    public void performApiCall(String url) {
        JsonObjectRequest request = new JsonObjectRequest(url, response -> {
            try {
                data.setText(response.getString("responseMessage"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }, error -> {
            Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
        });
        SingletonService.getInstance(context).addToRequestQueue(request);
    }
}
