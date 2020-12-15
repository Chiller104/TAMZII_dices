package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity_history extends AppCompatActivity {

    DBHelper mydb;
    ListView itemListView;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_history);

        delete = (Button) findViewById(R.id.delete);
        loadData();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydb.removeAll();
                recreate();
            }

        });
    }

    public void loadData(){

        mydb = new DBHelper(this);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList = mydb.getItemList();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.custom_list_view, arrayList);
        itemListView = findViewById(R.id.listView);
        itemListView.setAdapter(arrayAdapter);
    }
}