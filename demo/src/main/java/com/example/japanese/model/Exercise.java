package com.example.japanese.model;

public class Exercise {
    private String question;
    private String answer;
    private String level;

    public Exercise(String question, String answer, String level) {
        this.question = question; this.answer = answer; this.level = level;
    }

    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public String getLevel() { return level; }
}
