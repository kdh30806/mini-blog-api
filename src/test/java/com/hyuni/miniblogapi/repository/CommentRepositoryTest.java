package com.hyuni.miniblogapi.repository;

import com.hyuni.miniblogapi.domain.Comment;
import com.hyuni.miniblogapi.domain.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest @ExtendWith(SpringExtension.class)
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;
    @Autowired PostRepository postRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testComment() throws Exception{
        //given
        Post post = new Post();
        post.setTitle("제목입니다");
        post.setContent("내용입니다.");
        postRepository.save(post);

        Post post2 = new Post();
        post2.setTitle("제목입니다2");
        post2.setContent("내용입니다.2");
        postRepository.save(post2);

        Comment comment = new Comment();
        comment.setContent("댓글입니다.");
        comment.setPost(post);

        Comment comment2 = new Comment();
        comment2.setContent("댓글입니다.2");
        comment2.setPost(post);

        Comment comment3 = new Comment();
        comment3.setContent("댓글입니다.3");
        comment3.setPost(post);

        Comment comment4 = new Comment();
        comment4.setContent("댓글입니다.3");
        comment4.setPost(post2);

        //when
        Long commentId = commentRepository.save(comment);
        Long commentId2 = commentRepository.save(comment2);
        Long commentId3 = commentRepository.save(comment3);
        Long commentId4 = commentRepository.save(comment4);
    }
}