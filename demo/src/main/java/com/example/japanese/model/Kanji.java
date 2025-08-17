package com.example.japanese.model;

public class Kanji {
    private String character;
    private String meaning;
    private String onyomi;
    private String kunyomi;
    private String level;

    // Constructor with 5 parameters
    public Kanji(String character, String meaning, String onyomi, String kunyomi, String level) {
        this.character = character;
        this.meaning = meaning;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.level = level;
    }

    // Getters and Setters
    public String getCharacter() { return character; }
    public void setCharacter(String character) { this.character = character; }

    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }

    public String getOnyomi() { return onyomi; }
    public void setOnyomi(String onyomi) { this.onyomi = onyomi; }

    public String getKunyomi() { return kunyomi; }
    public void setKunyomi(String kunyomi) { this.kunyomi = kunyomi; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
