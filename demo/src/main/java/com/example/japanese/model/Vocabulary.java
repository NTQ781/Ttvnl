package com.example.japanese.model;

public class Vocabulary {
    private String japanese;
    private String reading;
    private String meaning;
    private String level; // Thêm thuộc tính level

    public Vocabulary(String japanese, String reading, String meaning, String level) {
        this.japanese = japanese;
        this.reading = reading;
        this.meaning = meaning;
        this.level = level;
    }

    public Vocabulary(String japanese, String reading, String meaning) {
        this(japanese, reading, meaning, "N5"); // Mặc định là N5
    }

    public String getJapanese() { return japanese; }
    public String getReading() { return reading; }
    public String getMeaning() { return meaning; }
    public String getLevel() { return level; }

    public void setJapanese(String japanese) { this.japanese = japanese; }
    public void setReading(String reading) { this.reading = reading; }
    public void setMeaning(String meaning) { this.meaning = meaning; }
    public void setLevel(String level) { this.level = level; }
}