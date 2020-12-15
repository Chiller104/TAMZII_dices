package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity_rules extends AppCompatActivity {

    TextView rules;
    View mainView;
    public final String SHARED_PREFERENCES = "sharePrefs";
    public final String wallpaper = "wooden_table";
    public String pozadie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rules);

        mainView = (View) findViewById(R.id.mainView);
        rules = (TextView) findViewById(R.id.rules);
        rules.setText("Ke hře potřebujeme 6 kostek. Hráč postupně hází kostky a podle toho co padne se zapisuje skóre\n" +
                "Hráč může házet až do té doby než řekne dost, ale když mu nic nepadne ztrácí vše čeho dosáhl v jednom kole.\n" +
                "S kostkama, na kterých něco padne se v jednom kole už nehází (kostky zmiznou) ! Když se podaří hodit tak, že jedním hodem na všech 6-ti" +
                " kostkách něco je musí si nechat zapsat body a kolo ukončit !\n" +
                "\nHodnoty:\n" +
                "1=100\n" +
                "5=50\n" +
                "3x číslo (2,3,4,5,6) = 200,300,400,500,600\n" +
                "4x číslo (2,3,4,5,6) = 400,600,800,1000,1200\n" +
                "5x číslo (2,3,4,5,6) = 800,1200,1600,2000,2400\n" +
                "6x číslo (2,3,4,5,6) = 1600,2400,3200,4000,4800\n" +
                "U jedničky je výjimka: \n111=1000,\n1111=2000,\n11111=4000,\n111111=8000\n" +
                "Postupka (123456) = 1500");
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