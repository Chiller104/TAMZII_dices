package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity_multiplayer_menu extends AppCompatActivity {

    EditText player1, player2;
    Button b4, b8, b12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_multiplayer_menu);

        player1 = findViewById(R.id.name_1);
        player2 = findViewById(R.id.name_2);

        b4 = (Button) findViewById(R.id.button_4000);
        b8 = (Button) findViewById(R.id.button_8000);
        b12 = (Button) findViewById(R.id.button_12000);

        b4.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {

                String p1 = player1.getText().toString();
                String p2 = player2.getText().toString();

                if (TextUtils.isEmpty(player1.getText())) {
                    player1.setError("Vyplnte meno hráča 1!");
                } else if (TextUtils.isEmpty(player2.getText())) {
                    player2.setError("Vyplnte meno hráča 2!");
                } else {
                    Intent i = new Intent(MainActivity_multiplayer_menu.this, MainActivity_multiplayer.class);
                    i.putExtra("player_1_name", p1);
                    i.putExtra("player_2_name", p2);
                    i.putExtra("final_score", 4000);
                    startActivity(i);
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
                    Intent i = new Intent(MainActivity_multiplayer_menu.this, MainActivity_multiplayer.class);
                    i.putExtra("player_1_name", p1);
                    i.putExtra("player_2_name", p2);
                    i.putExtra("final_score", 8000);
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
                    Intent i = new Intent(MainActivity_multiplayer_menu.this, MainActivity_multiplayer.class);
                    i.putExtra("player_1_name", p1);
                    i.putExtra("player_2_name", p2);
                    i.putExtra("final_score", 12000);
                    startActivity(i);
                }
            }
        });
    }
}