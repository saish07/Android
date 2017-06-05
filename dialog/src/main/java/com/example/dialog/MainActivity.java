package com.example.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAlert(View view){
        dialog(AppDialog.TAG_NO_INTERNET);
    }

    public void onDate(View view){
        dialog(AppDialog.TAG_DATE);
    }

    public void onTime(View view){
        dialog(AppDialog.TAG_TIME);
    }

    public void onProgress(View view){
        dialog(AppDialog.TAG_PROGRESS);
    }

    public void onCustom(View view){
        dialog(AppDialog.TAG_CUSTOM);
    }

    public void dialog(String tag){
        AppDialog dialog = new AppDialog();
        dialog.show(getSupportFragmentManager(), tag);
    }
}
