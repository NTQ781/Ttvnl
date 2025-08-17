package com.example.japanese.model;

public class Vocabulary {
    private String word;
    private String reading;
    private String meaning;
    private String level;

    // Constructor with 4 parameters
    public Vocabulary(String word, String reading, String meaning, String level) {
        this.word = word;
        this.reading = reading;
        this.meaning = meaning;
        this.level = level;
    }

    // Getters and Setters
    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }

    public String getReading() { return reading; }
    public void setReading(String reading) { this.reading = reading; }

    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
