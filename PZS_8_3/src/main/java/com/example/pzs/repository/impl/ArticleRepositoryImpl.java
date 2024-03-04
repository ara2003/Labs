package com.example.pzs.repository.impl;

import com.example.pzs.entity.Article;
import com.example.pzs.entity.Comment;
import com.example.pzs.repository.AbstractLongJpaRepository;
import com.example.pzs.repository.ArticleRepository;
import com.example.pzs.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class ArticleRepositoryImpl extends AbstractLongJpaRepository<Article> implements ArticleRepository {

    private final CommentRepository commentRepository;

    @Override
    public Optional<Article> findByTitle(String tile) {
        return entities.stream().filter(x -> tile.equals(x.getTitle())).findAny();
    }

    @Override
    public Article save(Article article) {
        article = super.save(article);
        for (Comment comment : article.getComments()) {
            comment.setArticle(article);
        }
        article.getOwner().getArticles().add(article);
        return article;
    }

    @Override
    public void delete(Article article) {
        for (Comment comment : article.getComments()) {
            commentRepository.delete(comment);
        }
        article.getOwner().getArticles().remove(article);
        super.delete(article);
    }

}
