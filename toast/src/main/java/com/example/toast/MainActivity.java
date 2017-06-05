package com.example.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onToast(View view){
        Toast toast = Toast.makeText(this, "Toast Message", Toast.LENGTH_SHORT);
        Button btn = new Button(this);
        btn.setText("Android");
        toast.setView(btn);

        toast.show();
    }
}
