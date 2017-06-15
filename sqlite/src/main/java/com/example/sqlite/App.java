package com.example.sqlite;

import android.app.Application;

/**
 * Created by saish on 15/6/17.
 */

public class App extends Application {

    private DbHelper helper;


    @Override
    public void onCreate() {
        super.onCreate();

        helper = new DbHelper(this, "code.sqlite", null, 1);
    }

    public DbHelper helper(){
        return helper;
    }
}
