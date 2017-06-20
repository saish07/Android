package com.example.notepad;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    public static final String KEY_NAME = "Filename";
    public static final String KEY_INFO = "info";
    public static final String KEY_SIZE = "position";

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        save();
        back();


        loadFileList();


    }

    private void loadFileList() {

        final List<FileItem> items = new ArrayList<>();
    }


    private void save() {

        findViewById(R.id.imgSave).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String filename = ((EditText) findViewById(R.id.editText)).getText().toString();
                Intent intent=new Intent(Main2Activity.this,FileStorage.class);
                startActivity(intent);

            }
        });
    }


            private void back(){

                findViewById(R.id.imgBack).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    });
                }


    }


