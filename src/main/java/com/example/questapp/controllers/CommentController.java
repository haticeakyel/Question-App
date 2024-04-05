package com.example.questapp.controllers;

import com.example.questapp.entities.Comment;
import com.example.questapp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId){
        return commentService.getAllCommentsWithParam(userId, postId);
    }
    
    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId){
        return commentService.getComment(commentId);
    }
}
