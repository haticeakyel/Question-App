package com.example.questapp.repos;

import com.example.questapp.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeInterface extends JpaRepository<Like,Long> {
}
