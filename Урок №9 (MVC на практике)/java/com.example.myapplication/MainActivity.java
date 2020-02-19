package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button TrueBtn;
    private Button FalseBtn;
    private TextView QuestionView;
    private Question[] questions = new Question[]{
            new Question(R.string.question_text, true),
            new Question(R.string.question_text1, false),
            new Question(R.string.question_text2, true),
            new Question(R.string.question_text3, true),
            new Question(R.string.question_text4,false)
    };
    private byte CurrentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TrueBtn = (Button) findViewById(R.id.true_btn);
        FalseBtn = (Button) findViewById(R.id.false_btn);
        QuestionView=(TextView) findViewById(R.id.question_view);
        TrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                CurrentIndex++;
                updateQuestion();
            }
        });
        FalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                CurrentIndex++;
                updateQuestion();
            }
        });

        updateQuestion();
    }

    private void updateQuestion(){
        int questionId = questions[CurrentIndex].getTextId();
        QuestionView.setText(questionId);
    }

    private void checkAnswer(boolean userAnswer){
        boolean answer = questions[CurrentIndex].isAnswer();
        if (userAnswer==answer){
            Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }
}
