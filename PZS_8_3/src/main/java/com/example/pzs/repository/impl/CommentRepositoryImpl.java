package com.example.pzs.repository.impl;

import com.example.pzs.entity.Comment;
import com.example.pzs.repository.AbstractLongJpaRepository;
import com.example.pzs.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CommentRepositoryImpl extends AbstractLongJpaRepository<Comment> implements CommentRepository {

    @Override
    public Optional<Comment> findByText(String text) {
        return entities.stream().filter(x -> text.equals(x.getText())).findAny();
    }

    @Override
    public Comment save(Comment comment) {
        comment = super.save(comment);
        comment.getOwner().getComments().add(comment);
        comment.getArticle().getComments().add(comment);
        return comment;
    }

    @Override
    public void delete(Comment comment) {
        comment.getOwner().getComments().remove(comment);
        comment.getArticle().getComments().remove(comment);
        super.delete(comment);
    }

}
