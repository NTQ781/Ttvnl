package com.example.japanese.model;

import java.util.List;

public class Exercise {
    private String question;
    private List<String> options;
    private String answer;
    private String explanation;

    // Constructor mới
    public Exercise(String question, List<String> options, String answer, String explanation) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.explanation = explanation;
    }

    // Getter & Setter
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public String getExplanation() { return explanation; }
    public void setExplanation(String explanation) { this.explanation = explanation; }
}
