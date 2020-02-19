package com.example.myapplication;

public class Question {
    private int TextId;
    private boolean Answer;

    public Question(int textId, boolean answer) {
        TextId = textId;
        Answer = answer;
    }

    public int getTextId() {
        return TextId;
    }

    public void setTextId(int textId) {
        TextId = textId;
    }

    public boolean isAnswer() {
        return Answer;
    }

    public void setAnswer(boolean answer) {
        Answer = answer;
    }
}
