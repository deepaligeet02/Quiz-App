package com.example.quizmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class score extends AppCompatActivity {
    Button m;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        m = findViewById(R.id.button2);
        int score = getIntent().getIntExtra("score", 0);
        // Display the score in the layout
        TextView scoreTextView = findViewById(R.id.H_score);
        scoreTextView.setText("Your score: " + score);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(score.this, menu.class);
                startActivity(in);
            }
        });
    }
}
