package com.example.quizmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {
    Button jb;
    Button oop;
    Button inhert;
    Button file;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity);
        jb = findViewById(R.id.but1);
        oop = findViewById(R.id.but2);
        inhert = findViewById(R.id.but3);
        file = findViewById(R.id.but4);

        jb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(menu.this, cloud.class);
                startActivity(in);
            }
        });

        oop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(menu.this, block.class);
                startActivity(in);
            }
        });
        inhert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(menu.this, dev.class);
                startActivity(in);
            }
        });
        file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(menu.this, doker.class);
                startActivity(in);
            }
        });
    }
}

