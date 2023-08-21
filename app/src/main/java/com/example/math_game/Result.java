package com.example.math_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView result;
    Button retry;
    Button home;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.textViewres);
        retry = findViewById(R.id.buttonretry);
        home = findViewById(R.id.buttonhome);

        Intent intent = getIntent();
        score = intent.getIntExtra("score",0);
        String userScore = String.valueOf(score);
        result.setText("Your score: "+userScore);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Result.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}