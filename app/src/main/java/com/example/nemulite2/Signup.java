package com.example.nemulite2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {

    EditText usernameup,passwordup,confpassword;
    Button signup;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameup = findViewById(R.id.Usernamesignup);
        passwordup = findViewById(R.id.Passwordsignup);
        confpassword = findViewById(R.id.Passwordconf);
        signup = findViewById(R.id.btnsignup2);
        fauth = FirebaseAuth.getInstance();

        if(fauth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),Homepage.class));
            finish();
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usernameup.getText().toString();
                String pass = passwordup.getText().toString();
                String repass = confpassword.getText().toString();

                if (TextUtils.isEmpty(user)){
                    usernameup.setError("Username Is Required");
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    passwordup.setError("Password Is Required");
                    return;
                }
                if (TextUtils.isEmpty(repass)){
                    confpassword.setError("Input The Same Password");
                    return;
                }
                if(passwordup.length()<6){
                    passwordup.setError("Password must be > 6 Char");
                }

                fauth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Signup.this, "User Created Succesfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Homepage.class));
                        }else{
                            Toast.makeText(Signup.this, "Sign Up Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });




    }
}