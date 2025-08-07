package com.example.japanese.model;

public class Grammar {
    private String form; // Cấu trúc ngữ pháp
    private String meaning; // Nghĩa
    private String example; // Ví dụ
    private String level; // Cấp độ (N1, N2, ...)

    public Grammar() {}
    public Grammar(String form, String meaning, String example, String level) {
        this.form = form;
        this.meaning = meaning;
        this.example = example;
        this.level = level;
    }

    public String getForm() { return form; }
    public void setForm(String form) { this.form = form; }
    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }
    public String getExample() { return example; }
    public void setExample(String example) { this.example = example; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}