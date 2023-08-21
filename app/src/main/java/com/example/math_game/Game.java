package com.example.math_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
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

    CountDownTimer timer;
    private static final long START_TIMER_IN_MILIS = 10000;
    Boolean timer_running;
    long time_left_in_milis = START_TIMER_IN_MILIS;

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
                pauseTimer();

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
                resetTimer();
            }
        });
    }

    public void quesGen(){

        num1 = random.nextInt(100);
        num2 = random.nextInt(100);

        realans = num1+num2;

        question.setText(num1 + "+" + num2);
        timer();
    }

    public void timer(){
        timer = new CountDownTimer(time_left_in_milis, 1000) {
            @Override
            public void onTick(long milisUntilFinished) {

                time_left_in_milis = milisUntilFinished;
                updateText();

            }

            @Override
            public void onFinish() {

                timer_running =false;
                pauseTimer();
                resetTimer();
                updateText();
                userlife -= 1;
                life.setText(""+userlife);
                question.setText("Time's up!");

            }
        }.start();

        timer_running = true;
    }

    public void updateText(){
        int second = (int)(time_left_in_milis/1000)%60;
        String time_left = String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);
    }

    public void pauseTimer(){
        timer.cancel();
        timer_running = false;
    }

    public void resetTimer(){
        time_left_in_milis = START_TIMER_IN_MILIS;
        updateText();
    }
}