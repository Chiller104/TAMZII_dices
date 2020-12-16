package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity_multiplayer_menu extends AppCompatActivity {

    EditText player1, player2;
    Button b4, b8, b12, history, pokracovat;
    View mainView;

    public final String SHARED_PREFERENCES = "sharePrefs";
    public final String WALLPAPER = "wooden_table";
    public final String HRAC1 = "hrac1";
    public final String HRAC2 = "hrac2";
    public final String SCORE1 = "score1";
    public final String SCORE2 = "score2";
    public final String TSCORE1 = "tscore1";
    public final String TSCORE2 = "tscore2";
    public final String ENDING = "ending";

    int score1 = 0;
    int score2 = 0;
    int total1 = 0;
    int total2 = 0;
    public String pozadie;
    public Integer ending_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_multiplayer_menu);

        player1 = findViewById(R.id.name_1);
        player2 = findViewById(R.id.name_2);

        pokracovat = (Button) findViewById(R.id.pokracovat);
        b4 = (Button) findViewById(R.id.button_4000);
        b8 = (Button) findViewById(R.id.button_8000);
        b12 = (Button) findViewById(R.id.button_12000);
        history = (Button) findViewById(R.id.history);

        pokracovat.setVisibility(View.VISIBLE);
        mainView = (View) findViewById(R.id.mainView);
        loadData();
        updateViews();

        pokracovat.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                    Intent i = new Intent(MainActivity_multiplayer_menu.this, MainActivity_multiplayer.class);
                    startActivity(i);
                    finish();
                }
        });

        b4.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {

                String p1 = player1.getText().toString();
                String p2 = player2.getText().toString();

                if (TextUtils.isEmpty(player1.getText())) {
                    player1.setError("Vyplnte meno hráča 1!");
                } else if (TextUtils.isEmpty(player2.getText())) {
                    player2.setError("Vyplnte meno hráča 2!");
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString(HRAC1, p1);
                    editor.putString(HRAC2, p2);
                    editor.putInt(SCORE1, 0);
                    editor.putInt(SCORE2, 0);
                    editor.putInt(TSCORE1, 0);
                    editor.putInt(TSCORE2, 0);
                    editor.putInt(ENDING, 1000);
                    editor.commit();

                    pozadie = sharedPreferences.getString(WALLPAPER, "");
                    p1 = sharedPreferences.getString(HRAC1, "");
                    p2 = sharedPreferences.getString(HRAC2, "");
                    score1 = sharedPreferences.getInt(SCORE1, 0);
                    score2 = sharedPreferences.getInt(SCORE2, 0);
                    total1 = sharedPreferences.getInt(TSCORE1, 0);
                    total2 = sharedPreferences.getInt(TSCORE1, 0);
                    ending_score = sharedPreferences.getInt(ENDING, 1000);

                    System.out.println(" \n\npred vytvorenim hry: ");
                    System.out.println("Hrac 1 =  " + p1);
                    System.out.println("Hrac 2 =  " + p2);
                    System.out.println("Score 1 = " + score1);
                    System.out.println("Score 2 = " + score2);
                    System.out.println("Total Score 1 = " + score1);
                    System.out.println("Total Score 2 = " + score2);
                    System.out.println("Ending score = " + ending_score);

                    Intent i = new Intent(MainActivity_multiplayer_menu.this, MainActivity_multiplayer.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        b8.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {

                String p1 = player1.getText().toString();
                String p2 = player2.getText().toString();

                if (TextUtils.isEmpty(player1.getText())) {
                    player1.setError("Vyplnte meno hráča 1!");
                } else if (TextUtils.isEmpty(player2.getText())) {
                    player2.setError("Vyplnte meno hráča 2!");
                } else {

                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString(HRAC1, p1);
                    editor.putString(HRAC2, p2);
                    editor.putInt(SCORE1, 0);
                    editor.putInt(SCORE2, 0);
                    editor.putInt(TSCORE1, 0);
                    editor.putInt(TSCORE2, 0);
                    editor.putInt(ENDING, 4000);
                    editor.commit();
                    finish();
                    Intent i = new Intent(MainActivity_multiplayer_menu.this, MainActivity_multiplayer.class);
                    startActivity(i);

                }
            }
        });

        b12.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {

                String p1 = player1.getText().toString();
                String p2 = player2.getText().toString();

                if (TextUtils.isEmpty(player1.getText())) {
                    player1.setError("Vyplnte meno hráča 1!");
                } else if (TextUtils.isEmpty(player2.getText())) {
                    player2.setError("Vyplnte meno hráča 2!");
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString(HRAC1, p1);
                    editor.putString(HRAC2, p2);
                    editor.putInt(SCORE1, 0);
                    editor.putInt(SCORE2, 0);
                    editor.putInt(TSCORE1, 0);
                    editor.putInt(TSCORE2, 0);
                    editor.putInt(ENDING, 8000);
                    editor.commit();

                    Intent i = new Intent(MainActivity_multiplayer_menu.this, MainActivity_multiplayer.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        history.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                    Intent i = new Intent(MainActivity_multiplayer_menu.this, MainActivity_history.class);
                    finish();
                    startActivity(i);
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
        pozadie = sharedPreferences.getString(WALLPAPER, "");
        ending_score = sharedPreferences.getInt(ENDING, 0);
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
        else if(pozadie == "wallpaper_grass") {
            System.out.println("Nastavujem pozadie na wallpaper_grass");
            mainView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.wallpaper_grass));
        }

            System.out.println("toto je ending score = " + ending_score);

        if (ending_score == 0) {
            pokracovat.setVisibility(View.INVISIBLE);
        }
        else{
            pokracovat.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity_menu.class));
        finish();
        super.onBackPressed();
    }
}