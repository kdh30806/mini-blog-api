package com.hyuni.miniblogapi.repository;

import com.hyuni.miniblogapi.domain.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class PostRepositoryTest {

    @Autowired private PostRepository postRepository;

    @Test
    @Transactional
    public void testPost() throws Exception{
        //given
        Post post = new Post();
        post.setTitle("제목입니다");
        post.setContent("내용입니다.");

        //when
        Long postId = postRepository.save(post);
        Post findPost = postRepository.findOne(postId);

        //then
        assertEquals(findPost.getId(), postId);
    }
}