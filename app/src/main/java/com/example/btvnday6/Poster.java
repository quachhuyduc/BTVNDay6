package com.example.btvnday6;

public class Poster {

    private  int id;
    private String title;
    private String postImage;
    private String userAvatar;
    private String userName;

    private boolean isLike;

    public Poster() {
    }

    public Poster(int id, String title, String postImage, String userAvatar, String userName, boolean isLike) {
        this.id = id;
        this.title = title;
        this.postImage = postImage;
        this.userAvatar = userAvatar;
        this.userName = userName;
        this.isLike = isLike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
