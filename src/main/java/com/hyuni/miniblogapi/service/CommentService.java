package com.hyuni.miniblogapi.service;

import com.hyuni.miniblogapi.controller.CommentDto;
import com.hyuni.miniblogapi.domain.Comment;
import com.hyuni.miniblogapi.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<CommentDto> findCommentsByPostId(Long post_id){
        List<Comment> comments = commentRepository.findCommentsByPostId(post_id);
        return comments.stream()
                .map(comment -> new CommentDto(comment))
                .collect(Collectors.toList());
    }
    @Transactional
    public Long save(Comment comment){
        return commentRepository.save(comment);
    }
}
