package com.example.japanese.model;

import java.util.List;

public class Listening {
    private String title;
    private String audio;
    private String description;
    private String script;
    private List<Question> questions;

    public Listening(String title, String audio, String description, String script, List<Question> questions) {
        this.title = title;
        this.audio = audio;
        this.description = description;
        this.script = script;
        this.questions = questions;
    }

    public String getTitle() { return title; }
    public String getAudio() { return audio; }
    public String getDescription() { return description; }
    public String getScript() { return script; }
    public List<Question> getQuestions() { return questions; }

    public static class Question {
        private String question;
        private String placeholder;

        public Question(String question, String placeholder) {
            this.question = question;
            this.placeholder = placeholder;
        }

        public String getQuestion() { return question; }
        public String getPlaceholder() { return placeholder; }
    }
}
