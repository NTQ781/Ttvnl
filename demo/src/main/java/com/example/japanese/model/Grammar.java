package com.example.japanese.model;

public class Grammar {
    private String structure;
    private String explanation;
    private String example;
    private String exampleMeaning;
    private String level;

    // Constructor with 5 parameters
    public Grammar(String structure, String explanation, String example, String exampleMeaning, String level) {
        this.structure = structure;
        this.explanation = explanation;
        this.example = example;
        this.exampleMeaning = exampleMeaning;
        this.level = level;
    }

    // Getters and Setters
    public String getStructure() { return structure; }
    public void setStructure(String structure) { this.structure = structure; }

    public String getExplanation() { return explanation; }
    public void setExplanation(String explanation) { this.explanation = explanation; }

    public String getExample() { return example; }
    public void setExample(String example) { this.example = example; }

    public String getExampleMeaning() { return exampleMeaning; }
    public void setExampleMeaning(String exampleMeaning) { this.exampleMeaning = exampleMeaning; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
