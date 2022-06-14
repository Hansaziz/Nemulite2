package com.example.nemulite2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button loginbtn,signupbtn,forgetpass;
    FirebaseAuth fauthlog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username =  findViewById(R.id.Username);
        password =  findViewById(R.id.Password);
        loginbtn =  findViewById(R.id.btnLogin);
        signupbtn = findViewById(R.id.btnsignup1);
        fauthlog = FirebaseAuth.getInstance();
        forgetpass = findViewById(R.id.btnforgetpass);



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();


                if (TextUtils.isEmpty(user)){
                    username.setError("Username Is Required");
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    password.setError("Password Is Required");
                    return;
                }

                if(password.length()<6){
                    password.setError("Password must be > 6 Char");
                }

                fauthlog.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Succesfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Homepage.class));
                        }else{
                            Toast.makeText(MainActivity.this, "Email Or Password Not Registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });




        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });


        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText resetmail = new EditText(view.getContext());
                AlertDialog.Builder passwordresetdial = new AlertDialog.Builder(view.getContext());
                passwordresetdial.setTitle("Reset Password ?");
                passwordresetdial.setMessage("Enter Your Email");
                passwordresetdial.setView(resetmail);
                passwordresetdial.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String mail = resetmail.getText().toString();
                        fauthlog.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(MainActivity.this, "Reset Link Sent To Your Email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Error ! Please Type Your Registered Email", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                passwordresetdial.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                passwordresetdial.create().show();
            }
        });



    }

    public void openSignup () {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
}