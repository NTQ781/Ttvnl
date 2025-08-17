package com.example.japanese.model;

public class Kanji {
    private String kanji;
    private String onyomi;
    private String kunyomi;
    private String meaning;
    private String example;
    private String level; // nếu bạn muốn thêm thông tin JLPT level

    public Kanji(String kanji, String onyomi, String kunyomi, String meaning, String example) {
        this.kanji = kanji;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.meaning = meaning;
        this.example = example;
    }

    // Constructor 6 tham số nếu HomeController đang dùng
    public Kanji(String kanji, String onyomi, String kunyomi, String meaning, String example, String level) {
        this.kanji = kanji;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.meaning = meaning;
        this.example = example;
        this.level = level;
    }

    // Getter & Setter
    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getOnyomi() {
        return onyomi;
    }

    public void setOnyomi(String onyomi) {
        this.onyomi = onyomi;
    }

    public String getKunyomi() {
        return kunyomi;
    }

    public void setKunyomi(String kunyomi) {
        this.kunyomi = kunyomi;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
