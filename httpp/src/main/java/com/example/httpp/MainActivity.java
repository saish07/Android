package com.example.httpp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.httpp.domain.Wh;

import org.json.JSONException;
import org.json.JSONObject;

import static android.location.LocationManager.*;

public class MainActivity extends AppCompatActivity {

    private LocationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;

        }
        manager.requestLocationUpdates(
                PASSIVE_PROVIDER,
                500,
                0.1f,
                new MyLocation()
        );
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

    private class MyLocation implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            ((TextView) findViewById(R.id.textView)).setText("Lat - " + location.getLatitude() + " Lng - " + location.getLongitude());

            postLocation(location.getLatitude(), location.getLongitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    public void postLocation(double lat, double lng) {

        JSONObject locObj = new JSONObject();
        try {
            locObj.put("lat", lat);
            locObj.put("lng", lng);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final App app = (App) getApplication();

        app.q().add(new JsonObjectRequest("https://realtime-location-21ec9.firebaseio.com/myLoc.jsongro", locObj, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(app, "Location Posted", Toast.LENGTH_SHORT).show();
            }

        },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(app, "Error", Toast.LENGTH_SHORT).show();
                    }

                }

        ));
    }
}
