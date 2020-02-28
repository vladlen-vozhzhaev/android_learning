package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
    private int CurrentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","onCreate() called");
        if (savedInstanceState != null)
            CurrentIndex = savedInstanceState.getInt("CurrentIndex",0);
        TrueBtn = (Button) findViewById(R.id.true_btn);
        FalseBtn = (Button) findViewById(R.id.false_btn);
        QuestionView=(TextView) findViewById(R.id.question_view);
        TrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                CurrentIndex=(CurrentIndex+1)%questions.length;
                updateQuestion();
            }
        });
        FalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                CurrentIndex=(CurrentIndex+1)%questions.length;
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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("CurrentIndex",CurrentIndex);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("MainActivity","onStart() - CALLED");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("MainActivity","onResume() - CALLED");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("MainActivity","onPause() - CALLED");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("MainActivity","onStop() - CALLED");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MainActivity","onDestroy() - CALLED");
    }
}
