package com.example.pzs.repository.impl;

import com.example.pzs.entity.Article;
import com.example.pzs.entity.Comment;
import com.example.pzs.entity.User;
import com.example.pzs.repository.AbstractLongJpaRepository;
import com.example.pzs.repository.ArticleRepository;
import com.example.pzs.repository.CommentRepository;
import com.example.pzs.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class UserRepositoryImpl extends AbstractLongJpaRepository<User> implements UserRepository {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return entities.stream().filter(x -> username.equals(x.getUsername())).findAny();
    }

    @Override
    public User save(User user) {
        user = super.save(user);
        for (Article article : user.getArticles()) {
            article.setOwner(user);
        }
        for (Comment comment : user.getComments()) {
            comment.setOwner(user);
        }
        return user;
    }

    @Override
    public void delete(User user) {
        for (Article article : user.getArticles()) {
            articleRepository.delete(article);
        }
        for (Comment comment : user.getComments()) {
            commentRepository.delete(comment);
        }
        super.delete(user);
    }

}
