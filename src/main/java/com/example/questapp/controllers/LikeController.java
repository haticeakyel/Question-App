package com.example.questapp.controllers;

import com.example.questapp.entities.Like;
import com.example.questapp.requests.LikeCreateRequest;
import com.example.questapp.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List <Like> listLikes(@RequestParam Optional<Long> userId, @RequestParam Optional <Long> postId){
        return likeService.getLikes(userId,postId);
    }

    @GetMapping("/{likeId}")
    public  Like getLike(@PathVariable Long id){
        return likeService.getLikeById(id);
    }

    @PostMapping
    public Like createLike(@RequestBody LikeCreateRequest likeCreateRequest){
        return likeService.saveLike(likeCreateRequest);
    }

    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable Long id){
        likeService.deleteLikeById(id);
    }
}