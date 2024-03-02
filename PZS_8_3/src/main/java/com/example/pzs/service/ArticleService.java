package com.example.pzs.service;

import com.example.pzs.dto.request.ArticleCreateRequest;
import com.example.pzs.dto.request.ArticleReplaceRequest;
import com.example.pzs.entity.Article;

import java.util.Collection;

public interface ArticleService {

    Article getOneArticle(long id);

    Collection<Article> getAllArticles();

    default void deleteArticles(Iterable<Article> articles) {
        for (var article : articles) {
            deleteArticle(article.getId());
        }
    }

    void deleteArticle(long id);

    Article replaceArticle(long id, ArticleReplaceRequest request);

    Article createArticle(ArticleCreateRequest request, long author);

}
