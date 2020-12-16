package com.example.projekt_kocky;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_settings extends AppCompatActivity {

    View mainView;
    ImageButton wall1, wall2, wall3;
    Switch sw1;
    public final String SHARED_PREFERENCES = "sharePrefs";
    public final String WALLPAPER = "wooden_table";
    public String pozadie;
    public final String SWITCH = "Switch";
    public Boolean music = false;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);

        mainView = findViewById(R.id.mainView);
        loadData();
        updateViews();

        wall1 = (ImageButton) findViewById(R.id.wall1);
        wall1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveData("wooden_table");
                loadData();
                updateViews();
                recreate();
            }
        });

        wall2 = (ImageButton) findViewById(R.id.wall2);
        wall2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveData("wallaper_galaxy");
                loadData();
                updateViews();
                recreate();
            }
        });

        wall3 = (ImageButton) findViewById(R.id.wall3);
        wall3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveData("wallpaper_grass");
                loadData();
                updateViews();
                recreate();
            }
        });
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               saveData("");
            }
        });
    }

    public void saveData(String wall){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (wall == "wooden_table"){
            editor.putString(WALLPAPER,"wooden_table");
        }
        else if (wall == "wallaper_galaxy"){
            editor.putString(WALLPAPER,"wallaper_galaxy");
        }
        else if (wall == "wallpaper_grass"){
            editor.putString(WALLPAPER,"wallpaper_grass");
        }
        editor.putBoolean(SWITCH, sw1.isChecked());

        editor.commit();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        pozadie = sharedPreferences.getString(WALLPAPER, "");
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
        System.out.println("SWitch je: " + music);
        sw1.setChecked(music);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity_menu.class));
        finish();
        super.onBackPressed();
    }
}