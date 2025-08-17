package com.example.japanese.model;

public class Vocabulary {
    private String word;
    private String reading;
    private String meaning;
    private String level;

    public Vocabulary(String word, String reading, String meaning, String level) {
        this.word = word; this.reading = reading; this.meaning = meaning; this.level = level;
    }

    public String getWord() { return word; }
    public String getReading() { return reading; }
    public String getMeaning() { return meaning; }
    public String getLevel() { return level; }
}
