package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity_menu extends AppCompatActivity {

    public static final Random random = new Random();
    private Button singleplayer, multiplayer, rules, random_generator, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        settings = (Button) findViewById(R.id.settings_button);
        singleplayer = (Button) findViewById(R.id.single);
        multiplayer = (Button) findViewById(R.id.multi);
        rules = (Button) findViewById(R.id.rules);
        random_generator = (Button) findViewById(R.id.random);

        /**----------TLACIDLO RANDOM-GENERATOR---------**/
        random_generator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity_menu.this, MainActivity_shaked.class));
            }
        });

        /**------------TLACIDLO SINGLEPLAYER-----------**/
        singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_menu.this, MainActivity_singleplayer.class));
            }
        });

        /**------------TLACIDLO MULTIPLAYER-----------**/
        multiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_menu.this, MainActivity_multiplayer_menu.class));
            }
        });

        /**------------TLACIDLO RULES-----------**/
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_menu.this, MainActivity_rules.class));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_menu.this, MainActivity_settings.class));
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

}

