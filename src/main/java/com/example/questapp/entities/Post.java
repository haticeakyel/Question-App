package com.example.questapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {
    public Post() {
    }
    @Id
    Long id;
    Long userId;
    String title;
    @Lob
    @Column(columnDefinition = "post")
    String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
