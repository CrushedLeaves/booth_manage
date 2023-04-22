package com.zjp.entity;

public class CommentUser {

    private Comment comment;

    private User user;

    @Override
    public String toString() {
        return "CommentUser{" +
                "comment=" + comment +
                ", user=" + user +
                '}';
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
