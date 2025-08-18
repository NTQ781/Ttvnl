package com.example.japanese.model;

import java.util.List;

public class Reading {
    private String title;
    private String content;
    private String translation;
    private List<Question> questions;

    public Reading(String title, String content, String translation, List<Question> questions) {
        this.title = title;
        this.content = content;
        this.translation = translation;
        this.questions = questions;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getTranslation() { return translation; }
    public List<Question> getQuestions() { return questions; }

    public static class Question {
        private String question;
        private String answer;
        private String translation;

        public Question(String question, String answer, String translation) {
            this.question = question;
            this.answer = answer;
            this.translation = translation;
        }

        public String getQuestion() { return question; }
        public String getAnswer() { return answer; }
        public String getTranslation() { return translation; }
    }
}
