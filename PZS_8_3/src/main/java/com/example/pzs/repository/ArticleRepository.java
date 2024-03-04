package com.example.pzs.repository;

import com.example.pzs.entity.Article;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findByTitle(String tile);

}
