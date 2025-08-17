package com.example.japanese.model;

public class KanaCharacter {
    private String character;
    private String romaji;

    public KanaCharacter(String character, String romaji) {
        this.character = character; this.romaji = romaji;
    }

    public String getCharacter() { return character; }
    public String getRomaji() { return romaji; }
}
