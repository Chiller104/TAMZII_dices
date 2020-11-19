package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollDices = (Button) findViewById(R.id.button);
        imageView1 = (ImageView) findViewById(R.id.diceView1);
        imageView2 = (ImageView) findViewById(R.id.diceView2);
        imageView3 = (ImageView) findViewById(R.id.diceView3);
        imageView4 = (ImageView) findViewById(R.id.diceView4);
        imageView5 = (ImageView) findViewById(R.id.diceView5);
        imageView6 = (ImageView) findViewById(R.id.diceView6);

        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value1 = randomDiceValue();
                int value2 = randomDiceValue();
                int value3 = randomDiceValue();
                int value4 = randomDiceValue();
                int value5 = randomDiceValue();
                int value6 = randomDiceValue();

                int res1 = getResources().getIdentifier("red_" + value1, "drawable", "com.example.projekt_kocky");
                int res2 = getResources().getIdentifier("white_" + value2, "drawable", "com.example.projekt_kocky");
                int res3 = getResources().getIdentifier("red_" + value3, "drawable", "com.example.projekt_kocky");
                int res4 = getResources().getIdentifier("red_" + value4, "drawable", "com.example.projekt_kocky");
                int res5 = getResources().getIdentifier("white_" + value5, "drawable", "com.example.projekt_kocky");
                int res6 = getResources().getIdentifier("red_" + value6, "drawable", "com.example.projekt_kocky");

                imageView1.setImageResource(res1);
                imageView2.setImageResource(res2);
                imageView3.setImageResource(res3);
                imageView4.setImageResource(res4);
                imageView5.setImageResource(res5);
                imageView6.setImageResource(res6);
            }
        });
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

}
