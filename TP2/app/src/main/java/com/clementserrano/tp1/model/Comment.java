package com.clementserrano.tp1.model;

public class Comment {
    String user;
    String content;
    int imageName;

    public Comment(String user, String content, int imageName) {
        this.user = user;
        this.content = content;
        this.imageName = imageName;
    }

    public String getUser() {

        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "user='" + user + '\'' +
                ", content='" + content + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
