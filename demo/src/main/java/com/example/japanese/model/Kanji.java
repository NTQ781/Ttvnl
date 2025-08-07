package com.example.japanese.model;

public class Kanji {
    private String kana; // Ký tự Kanji
    private String kun; // Âm Kun
    private String on; // Âm On
    private String meaning; // Nghĩa
    private String vocab; // Từ vựng liên quan
    private String level; // Cấp độ (N1, N2, ...)

    public Kanji() {}
    public Kanji(String kana, String kun, String on, String meaning, String vocab, String level) {
        this.kana = kana;
        this.kun = kun;
        this.on = on;
        this.meaning = meaning;
        this.vocab = vocab;
        this.level = level;
    }

    public String getKana() { return kana; }
    public void setKana(String kana) { this.kana = kana; }
    public String getKun() { return kun; }
    public void setKun(String kun) { this.kun = kun; }
    public String getOn() { return on; }
    public void setOn(String on) { this.on = on; }
    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }
    public String getVocab() { return vocab; }
    public void setVocab(String vocab) { this.vocab = vocab; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}