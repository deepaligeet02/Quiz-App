package com.example.quizmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class dev extends AppCompatActivity {
    private CountDownTimer timer;
    private long timeLeftInMillis; // The time left in milliseconds
    private static final long COUNTDOWN_INTERVAL = 1000; // The interval at which the timer will update (in milliseconds)
    private static final long COUNTDOWN_TIME = 10 * 60 * 1000; // Total time for the quiz in milliseconds (e.g., 1 minute)

    public static final String EXTRA_SCORE = "extraScore";
    private long backPressedTime;
    private TextView textViewQuestion;
    private TextView Correct;
    private TextView Wrong;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;
    private ColorStateList textColorDefaultRb;
    private int backgroundcoldef;
    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    public int score;
    private int wrongans = 0, correctans = 0;
    private boolean answered;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.devactivity);
        timeLeftInMillis = COUNTDOWN_TIME;
        startTimer();
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.timerTextView);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);
        textColorDefaultRb = rb1.getTextColors();
        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestion_TABLE4();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion();

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb1.setBackgroundColor(Color.WHITE);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb2.setBackgroundColor(Color.WHITE);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb3.setBackgroundColor(Color.WHITE);
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb4.setBackgroundColor(Color.WHITE);
            }
        });

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(dev.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();
        rb1.setBackgroundColor(Color.parseColor("#F3CC59"));
        rb2.setBackgroundColor(Color.parseColor("#FA6565"));
        rb3.setBackgroundColor(Color.parseColor("#8CF691"));
        rb4.setBackgroundColor(Color.parseColor("#2A9CF6"));
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");
        } else {
            finishQuiz();
        }
    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;

            textViewScore.setText("Score: " + score);
        }
        showSolution();
    }

    private void showSolution() {
        rb1.setBackgroundColor(Color.parseColor("#CF1B1B"));
        rb2.setBackgroundColor(Color.parseColor("#CF1B1B"));
        rb3.setBackgroundColor(Color.parseColor("#CF1B1B"));
        rb4.setBackgroundColor(Color.parseColor("#CF1B1B"));
        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                rb2.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                rb3.setBackgroundColor(Color.GREEN);
                break;
            case 4:
                rb4.setBackgroundColor(Color.GREEN);
                break;
        }

        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish");

        }
    }

    private void finishQuiz() {
        Intent intent = new Intent(dev.this, score.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    private void startTimer() {
        timer = new CountDownTimer(timeLeftInMillis, COUNTDOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerUI();
            }

            @Override
            public void onFinish() {
                TextView timerTextView = findViewById(R.id.timerTextView);
                // Timer has finished, handle the event (e.g., quiz submission)
                // You can show a message, disable UI elements, etc.
                // Example: submitQuiz();
                timerTextView.setText("00:00");
                Toast.makeText(dev.this, "Times Up!!", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void updateTimerUI() {
        TextView timerTextView = findViewById(R.id.timerTextView);
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerTextView.setText(timeFormatted);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }
}