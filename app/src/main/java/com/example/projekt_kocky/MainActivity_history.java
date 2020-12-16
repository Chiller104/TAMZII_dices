package com.example.projekt_kocky;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

    View mainView;
    DBHelper mydb;
    ListView itemListView;
    Button delete;
    public final String SHARED_PREFERENCES = "sharePrefs";
    public final String wallpaper = "wooden_table";
    public String pozadie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_history);

        mainView = findViewById(R.id.mainView);
        loadData();
        updateViews();

        delete = (Button) findViewById(R.id.delete);
        loadHistory();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydb.removeAll();
                recreate();
            }

        });
    }

    public void loadHistory(){

        mydb = new DBHelper(this);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList = mydb.getItemList();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.custom_list_view, arrayList);
        itemListView = findViewById(R.id.listView);
        itemListView.setAdapter(arrayAdapter);
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        pozadie = sharedPreferences.getString(wallpaper, "");
    }

    public void updateViews(){
        if(pozadie == "wooden_table") {
            System.out.println("Nastavujem pozadie na wooden_table");
            mainView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.wooden_table));
        }
        else if(pozadie == "wallaper_galaxy") {
            System.out.println("Nastavujem pozadie na wooden_table");
            mainView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.wallaper_galaxy));
        }
        if(pozadie == "wallpaper_grass") {
            System.out.println("Nastavujem pozadie na wallpaper_grass");
            mainView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.wallpaper_grass));
        }
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity_multiplayer_menu.class));
        finish();
        super.onBackPressed();
    }
}