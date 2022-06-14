package com.example.nemulite2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Waralabalist extends AppCompatActivity {

    private Button btnfood,btnbackwara,btndrinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waralabalist);

        btndrinks = (Button) findViewById(R.id.btndrink);
        btndrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrinks();
            }
        });

        btnbackwara = (Button) findViewById(R.id.btnbacklist);
        btnbackwara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openHomepageback();
            }
        });

        btnfood = (Button) findViewById(R.id.btnfood);
        btnfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityFood();
            }
        });
    }


    public void openDrinks(){
        Intent intent = new Intent(this,Drinks.class);
        startActivity(intent);
    }
    public void openActivityFood(){
        Intent intent = new Intent(this,Food.class);
        startActivity(intent);
    }

    public void openHomepageback(){
        Intent intent = new Intent(this,Homepage.class);
        startActivity(intent);
    }



}
