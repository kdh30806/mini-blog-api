package com.hyuni.miniblogapi.service;

import com.hyuni.miniblogapi.controller.PostDto;
import com.hyuni.miniblogapi.domain.Post;
import com.hyuni.miniblogapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(Post post){
        return postRepository.save(post);
    }

    public List<PostDto> findPosts(){
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> new PostDto(post))
                .collect(Collectors.toList());
    }

    public PostDto findPost(Long id){
        Post post = postRepository.findOne(id);
        return new PostDto(post);
    }
}
