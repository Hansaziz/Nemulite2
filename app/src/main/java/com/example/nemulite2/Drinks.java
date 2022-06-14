package com.example.nemulite2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Drinks extends AppCompatActivity {

    private Button btnmagicbrew,btnback2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        btnback2 = (Button) findViewById(R.id.backbuttondr);
        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWarlab();
            }
        });

        btnmagicbrew = (Button) findViewById(R.id.btnmagic);
        btnmagicbrew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityMagicBrew();
            }
        });


    }

    public void openActivityMagicBrew(){
        Intent intent = new Intent(this,Magicbrew.class);
        startActivity(intent);
    }

    public void openWarlab(){
        Intent intent = new Intent(this,Waralabalist.class);
        startActivity(intent);
    }



}