package com.example.japanese.model;

public class Reading {
    private String title;
    private String content;

    public Reading(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter + Setter
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
}
