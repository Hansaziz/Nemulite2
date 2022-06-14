package com.example.nemulite2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity {

    private Button btnwaralabalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btnwaralabalist = (Button) findViewById(R.id.btn_waralabalist);
        btnwaralabalist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWaralabalist();
            }
        });


    }
    public void openWaralabalist(){
        Intent intent = new Intent(this, Waralabalist.class);
        startActivity(intent);
    }


    public void Logout1(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(this,MainActivity.class));
    }
}