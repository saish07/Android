package com.example.activitystate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity{

    public static final String DATE = "date";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangeIs(View view) {
        ((TextView) findViewById(R.id.txtView)).setText(new Date().toString());
          }

            @Override
   protected void onSaveInstanceState(Bundle outState) {
               super.onSaveInstanceState(outState);
                outState.putString(DATE, ((TextView) findViewById(R.id.txtView)).getText().toString());
            }

            @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
               super.onRestoreInstanceState(savedInstanceState);
                if (savedInstanceState != null) {
                    ((TextView) findViewById(R.id.txtView))
                                       .setText(savedInstanceState.getString(DATE));
                   }
           }

           @Override
           protected void onDestroy() {
          super.onDestroy();
                mt("onDestroy");
           }

           private void mt(String msg) {
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
           }

}
