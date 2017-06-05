package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.listview.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simple();
    }
        public void simple()
        {

        List<String> dataSet = new ArrayList<>();
        dataSet.add("India");
        dataSet.add("China");
        dataSet.add("Japan");
        dataSet.add("Sri lanka");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSet);
        ((ListView) findViewById(R.id.lstCountries)).setAdapter(adapter);

        ((ListView)findViewById(R.id.listview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                ArrayAdapter<String> adapterLocal = (ArrayAdapter<String>) parent.getAdapter();
                String con = adapterLocal.getItem(position);
                ((EditText) findViewById(R.id.etCountry)).setText(con);
            }
        });


            }


}
