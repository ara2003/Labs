package com.example.pzs.service.impl;

import com.example.pzs.controller.advice.exception.CommentNotFoundException;
import com.example.pzs.dto.request.CommentCreateRequest;
import com.example.pzs.dto.request.CommentReplaceRequest;
import com.example.pzs.entity.Comment;
import com.example.pzs.repository.ArticleRepository;
import com.example.pzs.repository.CommentRepository;
import com.example.pzs.repository.UserRepository;
import com.example.pzs.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@AllArgsConstructor
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    @Override
    public Comment getOneComment(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));
    }

    @Override
    public Collection<Comment> getAllComments() {
        return repository.findAll();
    }

    @Override
    public void deleteComment(long id) {
        repository.deleteById(id);
    }

    @Override
    public Comment replaceComment(long id, CommentReplaceRequest request) {
        var user = getOneComment(id);
        var text = request.getText();
        if (text != null)
            user.setText(text);
        return repository.save(user);
    }

    @Transactional
    @Override
    public Comment createComment(CommentCreateRequest request, long author) {
        return repository.save(Comment
                .builder()
                .text(request.getText())
                .article(articleRepository.getReferenceById(request.getArticleId()))
                .owner(userRepository.getReferenceById(author))
                .build());
    }

}
