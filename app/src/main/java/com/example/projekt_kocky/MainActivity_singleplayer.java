package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;

import java.util.Random;

public class MainActivity_singleplayer extends AppCompatActivity {

    public static final Random random = new Random();
    private Button rollDices, endTurn, back;
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    private TextView score_counter, total_score_counter;
    private int value1, value2, value3, value4, value5, value6;

    private int res1, res2, res3, res4, res5, res6;
    int res1_red, res2_red, res3_red, res4_red, res5_red, res6_red;

    boolean flag1, flag2, flag3, flag4, flag5, flag6;
    boolean flag1_visibility, flag2_visibility, flag3_visibility, flag4_visibility, flag5_visibility, flag6_visibility;

    int score = 0;
    int last_roll_score = 0;
    int total_score = 0;

    int[] round_values = {0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer roll = MediaPlayer.create(this, R.raw.dice_roll);
        final MediaPlayer song = MediaPlayer.create(this, R.raw.song);

        song.start();
        back = (Button) findViewById(R.id.back_button);
        endTurn = (Button) findViewById(R.id.end_turn_button);
        rollDices = (Button) findViewById(R.id.button);

        imageView1 = (ImageView) findViewById(R.id.diceView1);
        imageView2 = (ImageView) findViewById(R.id.diceView2);
        imageView3 = (ImageView) findViewById(R.id.diceView3);
        imageView4 = (ImageView) findViewById(R.id.diceView4);
        imageView5 = (ImageView) findViewById(R.id.diceView5);
        imageView6 = (ImageView) findViewById(R.id.diceView6);

        score_counter = (TextView) findViewById(R.id.score);
        total_score_counter = (TextView) findViewById(R.id.total_score);

        res1 = getResources().getIdentifier("kostka", "drawable", "com.example.projekt_kocky");
        imageView1.setImageResource(res1);
        imageView2.setImageResource(res1);
        imageView3.setImageResource(res1);
        imageView4.setImageResource(res1);
        imageView5.setImageResource(res1);
        imageView6.setImageResource(res1);

        flag1_visibility = true;
        flag2_visibility = true;
        flag3_visibility = true;
        flag4_visibility = true;
        flag5_visibility = true;
        flag6_visibility = true;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song.stop();
                startActivity(new Intent(MainActivity_singleplayer.this, MainActivity_menu.class));
            }
        });

        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll.start();
                rolling();
            }
        });

        endTurn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                total_score = total_score + score;
                score = 0;
                last_roll_score = 0;
                score_counter.setText("Score: " + score);
                total_score_counter.setText("TOTAL Score: " + total_score);

                flag1_visibility = true;
                flag2_visibility = true;
                flag3_visibility = true;
                flag4_visibility = true;
                flag5_visibility = true;
                flag6_visibility = true;

                rollDices.setVisibility(View.VISIBLE);
                res1 = getResources().getIdentifier("kostka", "drawable", "com.example.projekt_kocky");
                imageView1.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                imageView4.setVisibility(View.VISIBLE);
                imageView5.setVisibility(View.VISIBLE);
                imageView6.setVisibility(View.VISIBLE);
                imageView1.setImageResource(res1);
                imageView2.setImageResource(res1);
                imageView3.setImageResource(res1);
                imageView4.setImageResource(res1);
                imageView5.setImageResource(res1);
                imageView6.setImageResource(res1);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag1 == false){
                    imageView1.setImageResource(res1_red);
                    flag1 = true;
                    flag1_visibility = false;
                    round_values[0] = value1;
                    mathematics(round_values);
                }
                else{
                    imageView1.setImageResource(res1);
                    flag1 = false;
                    flag1_visibility = true;
                    round_values[0] = 0;
                    mathematics(round_values);
                    }
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag2 == false){
                    imageView2.setImageResource(res2_red);
                    flag2 = true;
                    flag2_visibility = false;
                    round_values[1] = value2;
                    mathematics(round_values);
                }
                else{
                    imageView2.setImageResource(res2);
                    flag2 = false;
                    flag2_visibility = true;
                    round_values[1] = 0;
                    mathematics(round_values);
                }
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag3 == false){
                    imageView3.setImageResource(res3_red);
                    flag3 = true;
                    flag3_visibility = false;
                    round_values[2] = value3;
                    mathematics(round_values);
                }
                else{
                    imageView3.setImageResource(res3);
                    flag3 = false;
                    flag3_visibility = true;
                    round_values[2] = 0;
                    mathematics(round_values);
                }
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag4 == false){
                    imageView4.setImageResource(res4_red);
                    flag4 = true;
                    flag4_visibility = false;
                    round_values[3] = value4;
                    mathematics(round_values);
                }
                else{
                    imageView4.setImageResource(res4);
                    flag4 = false;
                    flag4_visibility = true;
                    round_values[3] = 0;
                    mathematics(round_values);
                }
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag5 == false){
                    imageView5.setImageResource(res5_red);
                    flag5 = true;
                    flag5_visibility = false;
                    round_values[4] = value5;
                    mathematics(round_values);
                }
                else{
                    imageView5.setImageResource(res5);
                    flag5 = false;
                    flag5_visibility = true;
                    round_values[4] = 0;
                    mathematics(round_values);
                }
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag6 == false){
                    imageView6.setImageResource(res6_red);
                    flag6 = true;
                    flag6_visibility = false;
                    round_values[5] = value6;
                    mathematics(round_values);
                }
                else{
                    imageView6.setImageResource(res6);
                    flag6 = false;
                    flag6_visibility = true;
                    round_values[5] = 0;
                    mathematics(round_values);
                }
            }
        });

        last_roll_score = mathematics(round_values);;
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

    public static int randomDiceValue() {
        return random.nextInt(6) + 1;
    }

    private void rotateDice(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);

        if(flag1_visibility==true){
            imageView1.setVisibility(View.VISIBLE);
            imageView1.startAnimation(anim);

        }
        if(flag2_visibility==true){
            imageView2.setVisibility(View.VISIBLE);
            imageView2.startAnimation(anim);
        }
        if(flag3_visibility==true){
            imageView3.setVisibility(View.VISIBLE);
            imageView3.startAnimation(anim);

        }
        if(flag4_visibility==true){
            imageView4.setVisibility(View.VISIBLE);
            imageView4.startAnimation(anim);
        }
        if(flag5_visibility==true){
            imageView5.setVisibility(View.VISIBLE);
            imageView5.startAnimation(anim);
        }
        if(flag6_visibility==true){
            imageView6.setVisibility(View.VISIBLE);
            imageView6.startAnimation(anim);
        }
    }

    private int mathematics(int[] pole){

        int count_of_0 = 0;
        int count_of_1 = 0;
        int count_of_2 = 0;
        int count_of_3 = 0;
        int count_of_4 = 0;
        int count_of_5 = 0;
        int count_of_6 = 0;

        score = last_roll_score;

        for(int i = 0; i < pole.length; i++){

            switch (pole[i]){
                case 0:
                    count_of_0 = count_of_0 + 1;
                    break;
                case 1:
                    count_of_1 = count_of_1 + 1;
                    break;
                case 2:
                    count_of_2 = count_of_2 + 1;
                    break;
                case 3:
                    count_of_3 = count_of_3 + 1;
                    break;
                case 4:
                    count_of_4 = count_of_4 + 1;
                    break;
                case 5:
                    count_of_5 = count_of_5 + 1;
                    break;
                case 6:
                    count_of_6 = count_of_6 + 1;
                    break;
            }
        }

        if (count_of_0 == 0){
            rollDices.setVisibility(View.INVISIBLE);
        }else{
            rollDices.setVisibility(View.VISIBLE);
        }

        /**-----------SMULA-----------**/
       /* if(count_of_1 == 0 && count_of_5 == 0 && count_of_2 < 3 && count_of_4 < 3 && count_of_3 < 3 && count_of_6 < 3) {

            smula.setVisibility(View.VISIBLE);
            rollDices.setVisibility(View.INVISIBLE);

        }*/
        /**-----------POSTUPKA-----------**/
        if (count_of_1 == 1 && count_of_2 == 1 && count_of_3 == 1 && count_of_4 == 1 && count_of_5 == 1 && count_of_6 == 1) {score = score + 1500;}
        /**-------Ostatne hodnoty-------**/
        else{
            if(count_of_1 == 1){score = score + 100;}
            else if(count_of_1 == 2){score = score + 200;}
            else if(count_of_1 == 3){score = score + 1000;}
            else if(count_of_1 == 4){score = score + 2000;}
            else if(count_of_1 == 5){score = score + 4000;}
            else if(count_of_1 == 6){score = score + 8000;}

            if(count_of_2 == 3){score = score + 200;}
            else if(count_of_2 == 4){score = score + 400;}
            else if(count_of_2 == 5){score = score + 800;}
            else if(count_of_2 == 6){score = score + 1600;}

            if(count_of_3 == 3){score = score + 300;}
            else if(count_of_3 == 4){score = score + 600;}
            else if(count_of_3 == 5){score = score + 1200;}
            else if(count_of_3 == 6){score = score + 2400;}

            if(count_of_4 == 3){score = score + 400;}
            else if(count_of_4 == 4){score = score + 800;}
            else if(count_of_4 == 5){score = score + 1600;}
            else if(count_of_4 == 6){score = score + 3200;}

            if(count_of_5 == 1){score = score + 50;}
            else if(count_of_5 == 2){score = score + 100;}
            else if(count_of_5 == 3){score = score + 500;}
            else if(count_of_5 == 4){score = score + 1000;}
            else if(count_of_5 == 5){score = score + 2000;}
            else if(count_of_5 == 6){score = score + 4000;}

            if(count_of_6 == 3){score = score + 600;}
            else if(count_of_6 == 4){score = score + 1200;}
            else if(count_of_6 == 5){score = score + 2400;}
            else if(count_of_6 == 6){score = score + 4800;}
        }

        score_counter.setText("Score: " + score);
        return score;
    }


    public void rolling(){

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            v.vibrate(400);
        }

        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag5 = false;
        flag6 = false;

        if(flag1_visibility==false){
            imageView1.setVisibility(View.INVISIBLE);
        }
        else imageView1.setVisibility(View.VISIBLE);
        if(flag2_visibility==false){
            imageView2.setVisibility(View.INVISIBLE);
        }
        else imageView2.setVisibility(View.VISIBLE);
        if(flag3_visibility==false){
            imageView3.setVisibility(View.INVISIBLE);
        }
        else imageView3.setVisibility(View.VISIBLE);
        if(flag4_visibility==false){
            imageView4.setVisibility(View.INVISIBLE);
        }
        else imageView4.setVisibility(View.VISIBLE);
        if(flag5_visibility==false){
            imageView5.setVisibility(View.INVISIBLE);
        }
        else imageView5.setVisibility(View.VISIBLE);
        if(flag6_visibility==false){
            imageView6.setVisibility(View.INVISIBLE);
        }
        else imageView6.setVisibility(View.VISIBLE);

        round_values[0] = 0;
        round_values[1] = 0;
        round_values[2] = 0;
        round_values[3] = 0;
        round_values[4] = 0;
        round_values[5] = 0;

        imageView1.setClickable(true);
        imageView2.setClickable(true);
        imageView3.setClickable(true);
        imageView4.setClickable(true);
        imageView5.setClickable(true);
        imageView6.setClickable(true);

        value1 = randomDiceValue();
        value2 = randomDiceValue();
        value3 = randomDiceValue();
        value4 = randomDiceValue();
        value5 = randomDiceValue();
        value6 = randomDiceValue();

        rotateDice();

        res1 = getResources().getIdentifier("white_" + value1, "drawable", "com.example.projekt_kocky");
        res1_red = getResources().getIdentifier("red_" + value1, "drawable", "com.example.projekt_kocky");
        res2 = getResources().getIdentifier("white_" + value2, "drawable", "com.example.projekt_kocky");
        res2_red = getResources().getIdentifier("red_" + value2, "drawable", "com.example.projekt_kocky");
        res3 = getResources().getIdentifier("white_" + value3, "drawable", "com.example.projekt_kocky");
        res3_red = getResources().getIdentifier("red_" + value3, "drawable", "com.example.projekt_kocky");
        res4 = getResources().getIdentifier("white_" + value4, "drawable", "com.example.projekt_kocky");
        res4_red = getResources().getIdentifier("red_" + value4, "drawable", "com.example.projekt_kocky");
        res5 = getResources().getIdentifier("white_" + value5, "drawable", "com.example.projekt_kocky");
        res5_red = getResources().getIdentifier("red_" + value5, "drawable", "com.example.projekt_kocky");
        res6 = getResources().getIdentifier("white_" + value6, "drawable", "com.example.projekt_kocky");
        res6_red = getResources().getIdentifier("red_" + value6, "drawable", "com.example.projekt_kocky");

        imageView1.setImageResource(res1);
        imageView2.setImageResource(res2);
        imageView3.setImageResource(res3);
        imageView4.setImageResource(res4);
        imageView5.setImageResource(res5);
        imageView6.setImageResource(res6);

        System.out.println("\nSCORE: " + score);
        System.out.println("LAST_ROLL_SCORE: " + last_roll_score);
        System.out.println("TOALA_SCORE: " + total_score);

        last_roll_score = score;
        score = 0;
        score_counter.setText("Score: " + last_roll_score);
        System.out.println("[ " + round_values[0] + " " + round_values[1] + " " + round_values[2] + " " + round_values[3] + " " + round_values[4] + " " + round_values[5] + " ]");
    }
}


