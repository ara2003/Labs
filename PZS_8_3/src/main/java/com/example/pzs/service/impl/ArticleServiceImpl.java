package com.example.pzs.service.impl;

import com.example.pzs.controller.advice.exception.ArticleNotFoundException;
import com.example.pzs.dto.request.ArticleCreateRequest;
import com.example.pzs.dto.request.ArticleReplaceRequest;
import com.example.pzs.entity.Article;
import com.example.pzs.repository.ArticleRepository;
import com.example.pzs.repository.UserRepository;
import com.example.pzs.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@AllArgsConstructor
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;
    private final UserRepository userRepository;

    @Override
    public Article getOneArticle(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
    }

    @Override
    public Collection<Article> getAllArticles() {
        return repository.findAll();
    }

    @Override
    public void deleteArticle(long id) {
        repository.deleteById(id);
    }

    @Override
    public Article replaceArticle(long id, ArticleReplaceRequest request) {
        var article = getOneArticle(id);
        var title = request.getTitle();
        if (title != null)
            article.setTitle(title);
        var text = request.getText();
        if (text != null)
            article.setText(text);
        return repository.save(article);
    }

    @Override
    public Article createArticle(ArticleCreateRequest request, long author) {
        return repository.save(Article.builder()
                .title(request.getTitle())
                .owner(userRepository.getReferenceById(author))
                .text(request.getText())
                .comments(new HashSet<>())
                .build());
    }

}
