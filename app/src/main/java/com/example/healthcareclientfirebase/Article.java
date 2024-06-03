package com.example.healthcareclientfirebase;

public class Article {
    private String title;
    private String content;
    private int imageResourceId; // Add this line

    public Article(String title, String content, int imageResourceId) {
        this.title = title;
        this.content = content;
        this.imageResourceId = imageResourceId; // Add this line
    }

    // Getter for title and content remain unchanged

    // Getter for the imageResourceId
    public int getImageResourceId() {
        return imageResourceId;
    }

    public CharSequence getTitle() {
        return title;
    }

    public void setTitle(CharSequence title) {
        this.title = (String) title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(boolean content) {
        this.content = String.valueOf(content);
    }
}
