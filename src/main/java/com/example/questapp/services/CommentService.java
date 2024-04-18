package com.example.questapp.services;

import com.example.questapp.entities.Comment;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;
import com.example.questapp.repos.CommentRepository;
import com.example.questapp.requests.CommentCreateRequest;
import com.example.questapp.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository,UserService userService, PostService postService){
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
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

    public Comment saveComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getOneUser(commentCreateRequest.getUserId());
        Post post = postService.getOnePost(commentCreateRequest.getPostId());
        if (user != null && post != null){
            Comment commentWillSaved = new Comment();
            commentWillSaved.setId(commentCreateRequest.getId());
            commentWillSaved.setPost(post);
            commentWillSaved.setUser(user);
            commentWillSaved.setText(commentCreateRequest.getText());
            return commentRepository.save(commentWillSaved);
        }
        else
            return null;

    }

    public Comment editComment(Long commentId, CommentUpdateRequest newComment) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()){
            Comment foundComment = comment.get();
            foundComment.setText(newComment.getText());
            return commentRepository.save(foundComment);
        }
        else {
            return null;
        }
    }

    public void deleteComment(Long commentId) {
         commentRepository.deleteById(commentId);
    }
}
