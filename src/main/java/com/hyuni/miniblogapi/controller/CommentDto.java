package com.hyuni.miniblogapi.controller;

import com.hyuni.miniblogapi.domain.Comment;
import lombok.Data;

@Data
public class CommentDto {
    private String content;

    public CommentDto(Comment comment) {
       content = comment.getContent();
    }
}
