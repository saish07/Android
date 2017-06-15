package com.example.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appPrivateWrite();
        populateList();
        

    }

    private void appPrivateRead() {

        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DCIM), "my.txt");
        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(file);

            while (true) {
                int ch = fis.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "Reading - " + builder.toString());
    }

    private void appPrivateWrite() {


        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DCIM), "my.txt");
        //File file = new File(getExternalFilesDir(""), "my.txt");
        Log.i(TAG, "App Private Path - " + file.getAbsolutePath());

        try
        {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("This annual day".getBytes());
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void publicSharedRead() {

        if(isMediaAvailable()){

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "my.txt");
            StringBuilder builder = new StringBuilder();
            try{
                FileInputStream fis = new FileInputStream(file);
                while (true) {
                  int ch = fis.read();
                  if (ch == -1) break;
                  else builder.append((char) ch);
                   }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.i(TAG, "Reading Public - " + builder.toString());

        }else Log.i(TAG, "Bad Media File");
    }

    private void publicSharedWrite() {

        if (isMediaAvailable()) {

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "my.txt");
            Log.i(TAG, "App Private Path - " + file.getAbsolutePath());

            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("This annual day".getBytes());
                fos.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else Log.i(TAG, "Bad Media File");
    }

    private void newPublicFolder(){
        File file = new File(Environment.getExternalStoragePublicDirectory("MyApp"), "annual-day");
        file.mkdir();

        File annualDay = new File(file, "hello.txt");
        try{
            annualDay.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Boolean isMediaAvailable() {
        return Environment.getExternalStorageState()
        .equals(Environment.MEDIA_MOUNTED);
    }

    private void populateList() {

        File file = Environment.getExternalStoragePublicDirectory("");
        //File file = getExternalFilesDir("");

        List<FileItem> fileItems = new ArrayList<>();
        File[] files = file.listFiles();

        for (File fl : files) {
            fileItems.add(new FileItem(fl.isDirectory() ? R.drawable.ic_folder_black_24dp : R.drawable.ic_insert_drive_file_black_24dp, fl.getName(), "" + fl.lastModified(), "" + fl.length()));
            }

            ((ListView) findViewById(R.id.listView)).setAdapter(new FileAdapter(this, fileItems));
        }
}






