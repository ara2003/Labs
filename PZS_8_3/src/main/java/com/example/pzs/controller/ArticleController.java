package com.example.pzs.controller;

import com.example.pzs.controller.advice.exception.ForbiddenException;
import com.example.pzs.dto.request.ArticleCreateRequest;
import com.example.pzs.dto.request.ArticleReplaceRequest;
import com.example.pzs.entity.Article;
import com.example.pzs.entity.User;
import com.example.pzs.service.ArticleService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.example.pzs.controller.Util.authenticated;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ArticleController {

    private static final Logger LOG = LogManager.getLogger(ArticleController.class);
    private final ArticleService service;

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return service.getAllArticles();
    }

    @GetMapping("/articles/{id}")
    public Article getOneArticle(@PathVariable long id) {
        return service.getOneArticle(id);
    }

    @PutMapping("/articles/{id}")
    public Article replaceArticle(Authentication authentication, @PathVariable long id, @RequestBody ArticleReplaceRequest request) {
        var startTime = System.nanoTime();
        try {
            var user = authenticated(authentication);
            checkAccess(user, id);
            return service.replaceArticle(id, request);
        } finally {
            var endTime = System.nanoTime();
            LOG.info("replaceArticle: " + (endTime - startTime) / 1_000_000_000f);
        }
    }

    private void checkAccess(User user, long articleId) {
        if (!service.getOneArticle(articleId).getOwner().equals(user))
            throw new ForbiddenException("user = " + user + " articleId = " + articleId);
    }

    @PostMapping("/articles")
    public Article createArticle(Authentication authentication, @RequestBody ArticleCreateRequest request) {
        var startTime = System.nanoTime();
        try {
            var user = authenticated(authentication);
            return service.createArticle(request, user.getId());
        } finally {
            var endTime = System.nanoTime();
            LOG.info("createArticle: " + (endTime - startTime) / 1_000_000_000f);
        }
    }

    @DeleteMapping("/articles/{id}")
    public void deleteOne(Authentication authentication, @PathVariable long id) {
        var startTime = System.nanoTime();
        try {
            var user = authenticated(authentication);
            checkAccess(user, id);
            service.deleteArticle(id);
        } finally {
            var endTime = System.nanoTime();
            LOG.info("deleteArticle: " + (endTime - startTime) / 1_000_000_000f);
        }
    }

}
