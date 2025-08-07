package com.example.japanese.model;

import java.util.List;

public class Exercise {
    private String question; // Câu hỏi
    private List<String> options; // Các lựa chọn
    private String correct; // Đáp án đúng
    private String level; // Cấp độ (N1, N2, ...)

    public Exercise() {}
    public Exercise(String question, List<String> options, String correct, String level) {
        this.question = question;
        this.options = options;
        this.correct = correct;
        this.level = level;
    }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }
    public String getCorrect() { return correct; }
    public void setCorrect(String correct) { this.correct = correct; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}