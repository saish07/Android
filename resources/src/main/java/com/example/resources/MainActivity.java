package com.example.resources;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        String title = getResources().getString(R.string.title);
        int color = getResources().getColor(R.color.colorPrimaryDark);
        color = ContextCompat.getColor(this, R.color.colorPrimaryDark);
        String[] courses = getResources().getStringArray(R.array,courses);

    }
}
