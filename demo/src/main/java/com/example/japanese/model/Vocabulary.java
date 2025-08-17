package com.example.japanese.model;

public class Vocabulary {
    private String word;
    private String reading;
    private String meaning;
    private String example;
    private String exampleMeaning;
    private String level;

    // Constructor with 6 parameters
    public Vocabulary(String word, String reading, String meaning, String example, String exampleMeaning, String level) {
        this.word = word;
        this.reading = reading;
        this.meaning = meaning;
        this.example = example;
        this.exampleMeaning = exampleMeaning;
        this.level = level;
    }

    // Getters and Setters
    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }

    public String getReading() { return reading; }
    public void setReading(String reading) { this.reading = reading; }

    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }

    public String getExample() { return example; }
    public void setExample(String example) { this.example = example; }

    public String getExampleMeaning() { return exampleMeaning; }
    public void setExampleMeaning(String exampleMeaning) { this.exampleMeaning = exampleMeaning; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
