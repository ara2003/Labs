package com.example.pzs.controller;

import com.example.pzs.controller.advice.exception.ForbiddenException;
import com.example.pzs.dto.request.ArticleCreateRequest;
import com.example.pzs.dto.request.ArticleReplaceRequest;
import com.example.pzs.entity.Article;
import com.example.pzs.entity.User;
import com.example.pzs.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.example.pzs.controller.Util.authenticated;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ArticleController {

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
        var user = authenticated(authentication);
        checkAccess(user, id);
        return service.replaceArticle(id, request);
    }

    private void checkAccess(User user, long articleId) {
        if (!service.getOneArticle(articleId).getOwner().equals(user))
            throw new ForbiddenException("user = " + user + " articleId = " + articleId);
    }

    @PostMapping("/articles")
    public Article createArticle(Authentication authentication, @RequestBody ArticleCreateRequest request) {
        var user = authenticated(authentication);
        return service.createArticle(request, user.getId());
    }

    @DeleteMapping("/articles/{id}")
    public void deleteOne(Authentication authentication, @PathVariable long id) {
        var user = authenticated(authentication);
        checkAccess(user, id);
        service.deleteArticle(id);
    }

}
