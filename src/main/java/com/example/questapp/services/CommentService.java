package com.example.questapp.services;

import com.example.questapp.entities.Comment;
import com.example.questapp.repos.CommentRepository;

import java.util.List;
import java.util.Optional;

public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }
        else if (userId.isPresent()){
            return commentRepository.findByUserId(userId.get());
        }
        else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        }
        else
            return commentRepository.findAll();
    }

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }
}
