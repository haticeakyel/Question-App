package com.example.questapp.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    Long id;
    Long postId;
    Long userId;
    String text;


    public CommentCreateRequest(Long id, Long postId, Long userId, String text) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
