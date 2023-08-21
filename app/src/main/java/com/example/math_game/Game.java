package com.example.math_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {

    TextView score;
    TextView life;
    TextView time;

    TextView question;
    EditText answer;

    Button enter;
    Button next;
    Random random = new Random();

    int num1,num2;
    int userans, realans, userscore = 0, userlife = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = findViewById(R.id.textViewScore);
        life = findViewById(R.id.textViewLife);
        time = findViewById(R.id.textViewTime);
        question = findViewById(R.id.textViewQues);
        answer = findViewById(R.id.editTextans);
        enter = findViewById(R.id.buttonenter);
        next = findViewById(R.id.buttonnext);

        quesGen();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userans = Integer.valueOf(answer.getText().toString());
                if(userans == realans){
                    userscore = userscore+10;
                    score.setText(""+userscore);
                    question.setText("Congrats, your answer is correct!");
                }
                else{
                        userlife -= 1;
                        life.setText(""+userlife);
                        question.setText("Oops! That was incorrect :(");
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer.setText("");
                quesGen();

            }
        });
    }

    public void quesGen(){

        num1 = random.nextInt(100);
        num2 = random.nextInt(100);

        realans = num1+num2;

        question.setText(num1 + "+" + num2);
    }

}