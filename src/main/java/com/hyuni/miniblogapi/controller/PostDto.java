package com.hyuni.miniblogapi.controller;

import com.hyuni.miniblogapi.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PostDto {

    private Long id;
    private String title;
    private String content;

    public PostDto(Post post) {
        id = post.getId();
        title = post.getTitle();
        content = post.getContent();
    }
}
