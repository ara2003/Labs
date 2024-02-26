package com.example.pzs.service;

import com.example.pzs.dto.request.CommentCreateRequest;
import com.example.pzs.dto.request.CommentReplaceRequest;
import com.example.pzs.entity.Comment;

import java.util.Collection;

public interface CommentService {

    Comment getOneComment(long id);

    Collection<Comment> getAllComments();

    void deleteComment(long id);

    Comment replaceComment(long id, CommentReplaceRequest request);

    Comment createComment(CommentCreateRequest request, long author);

}
