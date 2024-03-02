package com.example.pzs.controller;

import com.example.pzs.controller.advice.exception.ForbiddenException;
import com.example.pzs.dto.request.CommentCreateRequest;
import com.example.pzs.dto.request.CommentReplaceRequest;
import com.example.pzs.entity.Comment;
import com.example.pzs.entity.User;
import com.example.pzs.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.example.pzs.controller.Util.authenticated;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService service;

    @GetMapping("/comments")
    public Collection<Comment> getAllComments() {
        return service.getAllComments();
    }

    @GetMapping("/comments/{id}")
    public Comment getOneComment(@PathVariable long id) {
        return service.getOneComment(id);
    }

    @PutMapping("/comments/{id}")
    public Comment replaceComment(Authentication authentication, @PathVariable long id, @RequestBody CommentReplaceRequest request) {
        var user = authenticated(authentication);
        checkAccess(user, id);
        return service.replaceComment(id, request);
    }

    private void checkAccess(User user, long commentId) {
        if (!service.getOneComment(commentId).getOwner().equals(user))
            throw new ForbiddenException("user = " + user + " commentId = " + commentId);
    }

    @PostMapping("/comments")
    public Comment createComment(Authentication authentication, @RequestBody CommentCreateRequest request) {
        var user = authenticated(authentication);
        return service.createComment(request, user.getId());
    }

    @DeleteMapping("/comments/{id}")
    public void deleteOne(Authentication authentication, @PathVariable long id) {
        var user = authenticated(authentication);
        checkAccess(user, id);
        service.deleteComment(id);
    }

}
