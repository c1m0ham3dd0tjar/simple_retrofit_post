package com.retrofit_post;

public class PostModel {

    String title;
    String data;
    json json;

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }

    public com.retrofit_post.json getJson() {
        return json;
    }

    public PostModel(String title, String data) {
        this.title = title;
        this.data = data;
    }


}
