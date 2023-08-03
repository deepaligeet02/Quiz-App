package com.example.quizmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button log;
    EditText name, pass;
    QuizDbHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        log = findViewById(R.id.login);
        name = findViewById(R.id.uname);
        pass = findViewById(R.id.editTextTextPassword);
        DB = new QuizDbHelper(login.this);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                String userpass = pass.getText().toString();
                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(login.this, "Please Enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkuserpass = DB.chekusernamepassword(user, userpass);
                    if (checkuserpass == true) {
                        Toast.makeText(login.this, "Sign In Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), menu.class));
                    }
                }
            }
        });
    }
}
