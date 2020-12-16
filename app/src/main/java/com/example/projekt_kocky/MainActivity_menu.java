package com.example.projekt_kocky;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity_menu extends AppCompatActivity {

    private Button singleplayer, multiplayer, rules, random_generator;
    ImageView settings;
    View mainView;
    public final String SHARED_PREFERENCES = "sharePrefs";
    public final String wallpaper = "wooden_table";
    public String pozadie;
    public Integer ending_score = 0;
    public Integer score1 = 0;
    public Integer score2 = 0;
    public String meno1;
    public String meno2;

    public String hrac1 = "hrac1";
    public String hrac2 = "hrac2";
    public String s1 = "0";
    public String s2 = "0";
    public String ending = "ending";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mainView = findViewById(R.id.mainView);
        loadData();
        updateViews();

        settings = (ImageView) findViewById(R.id.settings);
        singleplayer = (Button) findViewById(R.id.single);
        multiplayer = (Button) findViewById(R.id.multi);
        rules = (Button) findViewById(R.id.rules);
        random_generator = (Button) findViewById(R.id.random);

        settings.setClickable(true);

        /**----------TLACIDLO RANDOM-GENERATOR---------**/
        random_generator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity_menu.this, MainActivity_shaked.class));
                finish();
            }
        });

        /**------------TLACIDLO SINGLEPLAYER-----------**/
        singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_menu.this, MainActivity_singleplayer.class));
                finish();
            }
        });

        /**------------TLACIDLO MULTIPLAYER-----------**/
        multiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_menu.this, MainActivity_multiplayer_menu.class));
                finish();
            }
        });

        /**------------TLACIDLO RULES-----------**/
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_menu.this, MainActivity_rules.class));
                finish();
            }
        });
        /**------------TLACIDLO SETTINGS-----------**/
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_menu.this, MainActivity_settings.class));
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflanter = getMenuInflater();
        inflanter.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:
                Intent myIntent = new Intent(this, MainActivity_menu.class);
                startActivity(myIntent);
                return true;
            case R.id.generator:
                Intent myIntent2 = new Intent(this, MainActivity_shaked.class);
                startActivity(myIntent2);
                return true;
            case R.id.singleplayer:
                Intent myIntent3 = new Intent(this, MainActivity_singleplayer.class);
                startActivity(myIntent3);
                return true;
            case R.id.multiplayer:
                Intent myIntent4 = new Intent(this, MainActivity_multiplayer_menu.class);
                startActivity(myIntent4);
                return true;
            case R.id.rules:
                Intent myIntent5 = new Intent(this, MainActivity_rules.class);
                startActivity(myIntent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void loadData(){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        pozadie = sharedPreferences.getString(wallpaper, "");
        ending_score = sharedPreferences.getInt(ending, 0);
        score1 = sharedPreferences.getInt(s1, 0);
        score2 = sharedPreferences.getInt(s2, 0);
        meno1 = sharedPreferences.getString(hrac1, "");
        meno2 = sharedPreferences.getString(hrac2, "");
        System.out.println(ending_score + " " + score1  + " " +  score2  + " " +  meno1 + " " +  meno2);
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
        closeContextMenu();
        startActivity(new Intent(this, MainActivity_menu.class));
        finish();
        super.onBackPressed();
    }
}

