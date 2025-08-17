package com.example.japanese.model;

public class Kanji {
    private String kanji;
    private String onyomi;
    private String kunyomi;
    private String meaning;
    private String level;

    public Kanji(String kanji, String onyomi, String kunyomi, String meaning, String level) {
        this.kanji = kanji; this.onyomi = onyomi; this.kunyomi = kunyomi; this.meaning = meaning; this.level = level;
    }

    public String getKanji() { return kanji; }
    public String getOnyomi() { return onyomi; }
    public String getKunyomi() { return kunyomi; }
    public String getMeaning() { return meaning; }
    public String getLevel() { return level; }
}
