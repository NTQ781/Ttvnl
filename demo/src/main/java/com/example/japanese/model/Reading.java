package com.example.japanese.model;

import java.util.List;

public class Reading {
    private String title;
    private String content;
    private String translation;
    private List<QA> questions;
    private String level; // N1-N5 (tùy chọn)

    public Reading(String title, String content, String translation, List<QA> questions, String level) {
        this.title = title;
        this.content = content;
        this.translation = translation;
        this.questions = questions;
        this.level = level;
    }

    public static class QA {
        private String q;
        private String a;
        private String t;

        public QA(String q, String a, String t) {
            this.q = q;
            this.a = a;
            this.t = t;
        }

        public String getQ() { return q; }
        public String getA() { return a; }
        public String getT() { return t; }
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getTranslation() { return translation; }
    public List<QA> getQuestions() { return questions; }
    public String getLevel() { return level; }
}
