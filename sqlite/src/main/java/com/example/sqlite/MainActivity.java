package com.example.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onInsert(View view){

        rawInsert();
    }

    public void onUpdate(View view){

        App app = (App) getApplication();

        String table = "codeTab";
        ContentValues values = new ContentValues();
        values.put("devNm", "apple");
        String whereClause = "proj = ?";
        String[] whereArgs = {"Notepad"};
        SQLiteDatabase sqDb = app.helper().getWritableDatabase();
        int reflected = sqDb.update(table, values, whereClause, whereArgs);
        Log.i("@codekul", "" + reflected + " rows reflected ");
        sqDb.close();

    }

    public void onDelete(View view){

        App app = (App) getApplication();
        String table = "codeTab";
        String whereClause = "desg = ?";
        String[] whereArgs = {"1"};
        SQLiteDatabase sqDb = app.helper().getWritableDatabase();
        int deleted = sqDb.delete(table, whereClause, whereArgs);
         Log.i("@codekul", "" + deleted + " rows deleted");
         sqDb.close();

    }

    public void onDisplay(View view){
        displayNames();
    }

    private void displayNames() {

        App app = (App) getApplication();
        SQLiteDatabase sqDb = app.helper().getReadableDatabase();

        String table = "codeTab";
        String[] columns = {"devNm"};
        String selection ="desg = ?";
        String[] selectionArgs = {"1"};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = sqDb.query(
                table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );

        while (cursor.moveToNext()) {

            String devNm = cursor.getString(0);

            Log.i("@codekul", "Name - " + devNm);
        }

        cursor.close();
        sqDb.close();
    }

        private void displayAll() {

        App app = (App) getApplication();
        SQLiteDatabase sqDb = app.helper().getReadableDatabase();

        String table = "codeTab";
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = sqDb.query(
                table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );

        while (cursor.moveToNext()) {

            String devNm = cursor.getString(0);
            int desg = cursor.getInt(1);
            String project = cursor.getString(cursor.getColumnIndex("proj"));

            Log.i("@codekul", "Name - " + devNm + " Desg - " + desg + " project - " + project);
        }

            cursor.close();
            sqDb.close();
    }

    private void rawInsert() {
         App app = (App) getApplication();
         SQLiteDatabase sqDb = app.helper().getWritableDatabase();
         sqDb.execSQL("insert into codeTab values('android','2', 'abc')");

        sqDb.close();
           }

    private void insertAndroid() {
        App app = (App) getApplication();

        String table = "codeTab";
        String nullColumnHack = null;

        ContentValues values = new ContentValues();
        values.put("devNm", "android");
        values.put("desg", 1);
        values.put("proj", "Notepad");

        SQLiteDatabase sqDb = app.helper().getWritableDatabase();
        Long row = sqDb.insert(table, nullColumnHack, values);
        if (row < 0) Log.i("@codekul", "Problem in insertion");
        else Log.i("@codekul", "Inserted successfully");
        sqDb.close();
    }
}


