package com.example.japanese.model;

public class Listening {
    private String title;
    private String audioUrl;

    public Listening(String title, String audioUrl) {
        this.title = title;
        this.audioUrl = audioUrl;
    }

    // Getter + Setter
    public String getTitle() {
        return title;
    }
    public String getAudioUrl() {
        return audioUrl;
    }
}
