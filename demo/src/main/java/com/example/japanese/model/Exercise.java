package com.example.japanese.model;

import java.util.List;

public class Exercise {
    private String question;
    private List<String> options;
    private String answer;
    private String explanation;
    private String level; // Thêm thuộc tính level

    // Constructor mới
    public Exercise(String question, List<String> options, String answer, String explanation, String level) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.explanation = explanation;
        this.level = level; // Khởi tạo level
    }

    // Getter & Setter cho question
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    // Getter & Setter cho options
    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    // Getter & Setter cho answer
    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    // Getter & Setter cho explanation
    public String getExplanation() { return explanation; }
    public void setExplanation(String explanation) { this.explanation = explanation; }

    // Getter & Setter cho level
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
