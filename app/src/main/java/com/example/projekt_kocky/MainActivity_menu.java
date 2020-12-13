package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity_menu extends AppCompatActivity {

    public static final Random random = new Random();
    private Button singleplayer, multiplayer, rules;
    ImageView kostka;
    int value, res1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        singleplayer = (Button) findViewById(R.id.single);
        multiplayer = (Button) findViewById(R.id.multi);
        rules = (Button) findViewById(R.id.rules);

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

        /**------------TLACIDLO SIBGLEPLAYER-----------**/
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_menu.this, MainActivity_rules.class));
            }
        });

        final MediaPlayer roll = MediaPlayer.create(this, R.raw.dice_roll);
        kostka = (ImageView) findViewById(R.id.menu_dice);
        kostka.setClickable(true);

        kostka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rotateDice();
                roll.start();
                value = random.nextInt(6) + 1;
                res1 = getResources().getIdentifier("white_" + value, "drawable", "com.example.projekt_kocky");
                kostka.setImageResource(res1);
            }
        });
    }

    private void rotateDice(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        kostka.startAnimation(anim);
    }

}

