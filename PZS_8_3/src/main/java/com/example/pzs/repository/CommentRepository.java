package com.example.pzs.repository;

import com.example.pzs.entity.Comment;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByText(String text);

}
