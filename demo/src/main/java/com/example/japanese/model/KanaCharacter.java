package com.example.japanese.model;

public class KanaCharacter {
    private String romaji;
    private String kana;

    public KanaCharacter() {}
    public KanaCharacter(String romaji, String kana) {
        this.romaji = romaji;
        this.kana = kana;
    }

    public String getRomaji() { return romaji; }
    public String getKana() { return kana; }

    public void setRomaji(String romaji) { this.romaji = romaji; }
    public void setKana(String kana) { this.kana = kana; }
}
