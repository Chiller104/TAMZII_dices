package com.example.projekt_kocky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity_rules extends AppCompatActivity {

    TextView rules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rules);

        rules = (TextView) findViewById(R.id.rules);
        rules.setText("Ke hře potřebujeme 6 kostek. Hráč postupně hází kostky a podle toho co padne se zapisuje skóre\n" +
                "Hráč může házet až do té doby než řekne dost, ale když mu nic nepadne ztrácí vše čeho dosáhl v jednom kole.\n" +
                "S kostkama, na kterých něco padne se v jednom kole už nehází (kostky zmiznou) ! Když se podaří hodit tak, že jedním hodem na všech 6-ti" +
                " kostkách něco je, musí se házet dál a musí něco padnout jinak hráč" +
                "o vše co hodil v jednom kole přichází.\n" +
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

}