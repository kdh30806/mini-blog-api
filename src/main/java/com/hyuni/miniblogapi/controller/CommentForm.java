package com.hyuni.miniblogapi.controller;

import lombok.Data;

@Data
public class CommentForm {
    private Long post_id;
    private String content;
}
