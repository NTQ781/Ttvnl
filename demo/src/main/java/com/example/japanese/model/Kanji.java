package com.example.japanese.model;

public class Kanji {
    private String character;
    private String kunyomi;
    private String onyomi;
    private String meaning;
    private String example;
    private String level;

    // Constructor with 6 parameters
    public Kanji(String character, String kunyomi, String onyomi, String meaning, String example, String level) {
        this.character = character;
        this.kunyomi = kunyomi;
        this.onyomi = onyomi;
        this.meaning = meaning;
        this.example = example;
        this.level = level;
    }

    // Getters and Setters
    public String getCharacter() { return character; }
    public void setCharacter(String character) { this.character = character; }

    public String getKunyomi() { return kunyomi; }
    public void setKunyomi(String kunyomi) { this.kunyomi = kunyomi; }

    public String getOnyomi() { return onyomi; }
    public void setOnyomi(String onyomi) { this.onyomi = onyomi; }

    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }

    public String getExample() { return example; }
    public void setExample(String example) { this.example = example; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
