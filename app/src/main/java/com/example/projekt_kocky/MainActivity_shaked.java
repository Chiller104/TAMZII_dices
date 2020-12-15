package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity_shaked extends AppCompatActivity {

    public static final Random random = new Random();
    ImageView kostka;
    private Button back;
    int value, res1;

    private SensorManager sm;
    private float acelVal;
    private  float scelLast;
    private float shake;

    View mainView;
    public final String SHARED_PREFERENCES = "sharePrefs";
    public final String wallpaper = "wooden_table";
    public String pozadie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_shaked);

        mainView = (View) findViewById(R.id.mainView);
        loadData();
        updateViews();

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        scelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

        kostka = (ImageView) findViewById(R.id.menu_dice);
        kostka.setClickable(true);
        back = (Button) findViewById(R.id.back_button);

        kostka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rotateDice();
                value = random.nextInt(6) + 1;
                res1 = getResources().getIdentifier("white_" + value, "drawable", "com.example.projekt_kocky");
                kostka.setImageResource(res1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity_shaked.this, MainActivity_menu.class));
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

    private void rotateDice(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        final MediaPlayer roll = MediaPlayer.create(this, R.raw.dice_roll);

        kostka.startAnimation(anim);
        roll.start();
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            scelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = acelVal - scelLast;
            shake = shake * 0.9f + delta;

            if (shake > 20){
                rotateDice();
                value = random.nextInt(6) + 1;
                res1 = getResources().getIdentifier("white_" + value, "drawable", "com.example.projekt_kocky");
                kostka.setImageResource(res1);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };


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
        startActivity(new Intent(this, MainActivity_menu.class));
        finish();
        super.onBackPressed();
    }

}

