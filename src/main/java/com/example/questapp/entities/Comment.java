package com.example.questapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    public Comment() {
    }
    @Id
    Long id;
    Long postId;
    Long userId;

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

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
