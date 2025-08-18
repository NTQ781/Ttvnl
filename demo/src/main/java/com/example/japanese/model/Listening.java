package com.example.japanese.model;

import java.util.List;

public class Listening {
    private String title;
    private String audio;
    private String content;
    private String level;
    private String script;
    private List<String> questions;

    public Listening(String title, String audio, String content, String level, String script, List<String> questions) {
        this.title = title;
        this.audio = audio;
        this.content = content;
        this.level = level;
        this.script = script;
        this.questions = questions;
    }

    public String getTitle() { return title; }
    public String getAudio() { return audio; }
    public String getContent() { return content; }
    public String getLevel() { return level; }
    public String getScript() { return script; }
    public List<String> getQuestions() { return questions; }
}
