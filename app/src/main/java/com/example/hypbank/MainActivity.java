package com.example.hypbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView data;
    TextView textView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = findViewById(R.id.data);
        url = "http://10.0.2.2:5174/api/CardValidator?cardNumber=4847954048973513";


        JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    data.setText(response.getString("responseMessage"));

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, error -> data.setText(String.format("Error Occurred: %s", error.getMessage())));
        Volley.newRequestQueue(this).add(request);
    }
}