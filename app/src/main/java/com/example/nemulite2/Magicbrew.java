package com.example.nemulite2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Magicbrew extends AppCompatActivity {

    private Button backmagic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magicbrew);

        backmagic = (Button) findViewById(R.id.btnbackmagic);
        backmagic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBackdr();
            }
        });
    }

    public void openBackdr(){
        Intent intent = new Intent(this,Drinks.class);
        startActivity(intent);
    }
}