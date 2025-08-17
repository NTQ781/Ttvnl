package com.example.japanese.model;

import java.util.List;

public class Exercise {
    private String question;
    private List<String> options;
    private String answer;
    private String explanation;
    private String level;

    // Constructor with 5 parameters
    public Exercise(String question, List<String> options, String answer, String explanation, String level) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.explanation = explanation;
        this.level = level;
    }

    // Getters and Setters
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public String getExplanation() { return explanation; }
    public void setExplanation(String explanation) { this.explanation = explanation; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
