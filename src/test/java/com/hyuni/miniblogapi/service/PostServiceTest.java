package com.hyuni.miniblogapi.service;

import com.hyuni.miniblogapi.domain.Post;
import com.hyuni.miniblogapi.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostServiceTest {

    @Autowired private PostService postService;
    @Autowired private PostRepository postRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void postServiceTest() throws Exception{
        //given
        Post post = new Post();
        post.setContent("최민지 바보");
        post.setTitle("최민지 바보");
        //when
        Long postId = postService.save(post);
        Post findPost = postRepository.findOne(post.getId());
        //then
        assertEquals(postId, findPost.getId());
    }
}