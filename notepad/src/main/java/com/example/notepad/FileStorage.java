package com.example.notepad;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStorage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);

        custom();
    }


        private void custom(){

            Db.items.add(new FileItem(R.id.imgIC, "my.txt", ""));

            final FileAdapter adapter = new FileAdapter(this, Db.items);


        ((ListView) findViewById(R.id.listVw)).setAdapter(adapter);
        ((ListView) findViewById(R.id.listVw)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivityForResult(new Intent(FileStorage.this, Edit.class), 586);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ((FileAdapter) ((ListView) findViewById(R.id.listVw)).getAdapter()).notifyDataSetChanged();
    }

    public void onBack(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

}







