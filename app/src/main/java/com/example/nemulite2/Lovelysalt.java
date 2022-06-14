package com.example.nemulite2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lovelysalt extends AppCompatActivity {

    private Button btnbacklove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovelysalt);

        btnbacklove = (Button) findViewById(R.id.btnbacklove);
        btnbacklove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityFoodback();
            }
        });
    }
    public void openActivityFoodback(){
        Intent intent = new Intent(this,Food.class);
        startActivity(intent);
    }
}