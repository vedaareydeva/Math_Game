package com.example.math_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addition;
    Button subtraction;
    Button multiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addition = findViewById(R.id.BtnAdd);
        subtraction = findViewById(R.id.BtnSub);
        multiplication = findViewById(R.id.BtnMul);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Game.class);
                startActivity(intent);

            }
        });
    }
}