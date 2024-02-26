package com.example.pzs.dto.request;

import lombok.Data;

@Data
public class CommentCreateRequest {

    String text;
    long articleId;

}
