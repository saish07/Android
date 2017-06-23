package com.example.httpp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.httpp.domain.Wh;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOkay(View view) {
        App app = (App) getApplication();

        String lat = ((EditText) findViewById(R.id.etLat)).getText().toString();
        String lon = ((EditText) findViewById(R.id.etLon)).getText().toString();
        final ProgressDialog pd = ProgressDialog.show(MainActivity.this, "Weather", "Fetching your weather data");

        app.q().add(new StringRequest("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&mode=json&units=metric&cnt=7&appid=7406c21bb1cb9f59d936a59c4e890279", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("@codekul", "Response is " + response);
                Wh wh = ((App) getApplication()).gson()
                        .fromJson(response, Wh.class);

                String data = wh.getMain().getTemp() + ", " + wh.getName() + ", " + wh.getSys().getCountry();
                ((TextView) findViewById(R.id.textView))
                        .setText(data);
                pd.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
            }
        }));
    }
}
