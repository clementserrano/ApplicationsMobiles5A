package com.clementserrano.tp1;

public class Comment {
    String user;
    String content;
    String imageName;

    public Comment(String user, String content, String imageName) {
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
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
