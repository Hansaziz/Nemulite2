package com.example.nemulite2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Food extends AppCompatActivity {

    private Button btnlove,btnfoodback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        btnfoodback = (Button) findViewById(R.id.btnfoodback);
        btnfoodback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitywaralab();
            }
        });

        btnlove = (Button) findViewById(R.id.btnlovely);
        btnlove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityLovelySalt();
            }
        });
    }

    public void openActivityLovelySalt(){
        Intent intent = new Intent(this,Lovelysalt.class);
        startActivity(intent);

    }

    public void openActivitywaralab(){
        Intent intent = new Intent(this,Waralabalist.class);
        startActivity(intent);

    }
}