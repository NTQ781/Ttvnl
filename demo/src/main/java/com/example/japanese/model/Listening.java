package com.example.japanese.model;

import java.util.List;

public class Listening {
    private String title;
    private String audioUrl;
    private String description;
    private String level;
    private List<Question> questions;

    public Listening(String title, String audioUrl, String description, String level, List<Question> questions) {
        this.title = title; this.audioUrl = audioUrl; this.description = description;
        this.level = level; this.questions = questions;
    }

    public String getTitle() { return title; }
    public String getAudioUrl() { return audioUrl; }
    public String getDescription() { return description; }
    public String getLevel() { return level; }
    public List<Question> getQuestions() { return questions; }
}
