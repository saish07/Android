package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.json.Domain.Device;
import com.example.json.Domain.Mouse;
import com.example.json.Domain.Our;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parseUsingGson();
    }


    private void parseUsingNativeApi() {
        String json = Util.readAssests(this);
        Log.i("@codekul", "We Have - " + json);
        try {
            JSONObject obj = new JSONObject(json);
            Log.i("@codekul", "Key Int - " + obj.getInt("keyNum"));
            Log.i("@codekul", "Key String - " + obj.getString("keyString"));

            JSONArray adds = obj.getJSONArray("adds");
            for (int i = 0; i < adds.length(); i++) {
                Log.i("@codekul", "Address is - " + adds.getString(i));
            }

            JSONObject mouse = obj.getJSONObject("mouse");
            Log.i("@codekul", "Mouse Name - " + mouse.getString("name"));
            Log.i("@codekul", "Mouse Cost - " + mouse.getInt("cost"));

            JSONArray devices = obj.getJSONArray("devices");
            for (int i = 0; i < devices.length(); i++) {
                JSONObject device = devices.getJSONObject(i);
                Log.i("@codekul", "Name - " + device.getString("name"));
                Log.i("@codekul", "Cost - " + device.getInt("cost"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseUsingGson() {
        Gson gson = new Gson();
        Our our = gson.fromJson(Util.readAssests(this), Our.class);
        Log.i("@codekul", "Integer - " + our.getKeyNum());
        Log.i("@codekul", "String - " + our.getKeyString());
        for (String add : our.getAdds()) {
            Log.i("@codekul", "Add - " + add);
        }
        Mouse mouse = our.getMouse();
        Log.i("@codekul", "Mouse Name - " + mouse.getName() + " Mouse Cost - " + mouse.getCost());
        for (Device device : our.getDevices()) {
            Log.i("@codekul", "device Name - " + device.getName() + " device Cost - " + device.getCost());
        }
    }
}