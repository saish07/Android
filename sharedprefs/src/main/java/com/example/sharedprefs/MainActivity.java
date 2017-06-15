package com.example.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();
    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("my_prefs", MODE_APPEND);
    }

    public void onWrite(View view){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("itsBoolean", true);
        editor.putFloat("itsFloat", 345.43f);
        editor.putString("itsString", "codekul.com");
        editor.apply();

    }

    public void onRead(View view){
        boolean _boolean = prefs.getBoolean("itsBoolean", false);
        float _float = prefs.getFloat("itsFloat", 0.3f);
        String _string = prefs.getString("itsString", ":(");
        Log.i(TAG, "Boolean - " + _boolean + " Float - " + _float + " String - " + _string);
        ((TextView) findViewById(R.id.txtInfo)).setText("Boolean - " + _boolean + " Float - " + _float + " String - " + _string);
    }
}
