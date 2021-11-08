package com.example.speechkin1.models;

public class Post {
    private int id;
    private String Title;
    private String body;

    public Post() {
    }

    public Post(int id, String title, String body) {
        this.id = id;
        this.Title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
