package com.example.japanese.model;

public class Grammar {
    private String pattern;
    private String meaning;
    private String example;
    private String level;

    public Grammar(String pattern, String meaning, String example, String level) {
        this.pattern = pattern; this.meaning = meaning; this.example = example; this.level = level;
    }

    public String getPattern() { return pattern; }
    public String getMeaning() { return meaning; }
    public String getExample() { return example; }
    public String getLevel() { return level; }
}
