package com.example.handleruntimechangesv2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((ImageView) findViewById(R.id.imgView)).setImageResource(R.drawable.ic_logo);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            ((ImageView) findViewById(R.id.imgView)).setImageResource(R.drawable.ic_logo1);
        } else {
            ((ImageView) findViewById(R.id.imgView)).setImageResource(R.drawable.index);
        }
        }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
           }
    }
