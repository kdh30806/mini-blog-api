package com.hyuni.miniblogapi.controller;

import com.hyuni.miniblogapi.domain.Comment;
import com.hyuni.miniblogapi.domain.Post;
import com.hyuni.miniblogapi.repository.PostRepository;
import com.hyuni.miniblogapi.service.CommentService;
import com.hyuni.miniblogapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3030")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RestController {

    private final PostService postService;
    private final PostRepository postRepository;
    private final CommentService commentService;

    //게시판 등록
    @PostMapping("post")
    public ResponseEntity<Long> savePost(@RequestBody Post post){
        return ResponseEntity.ok()
                .body(postService.save(post));
    }

    //게시판 목록 불러오기
    @GetMapping("posts")
    public ResponseEntity<List<PostDto>> posts(){
        return ResponseEntity.ok()
                .body(postService.findPosts());
    }

    //게시판 조회
    @GetMapping("post/{post_id}")
    public ResponseEntity<PostDto> post(@PathVariable Long post_id){
        return ResponseEntity.ok()
                .body(postService.findPost(post_id));
    }

    //댓글 목록 불러오기
    @GetMapping("comments/{post_id}")
    public ResponseEntity<List<CommentDto>> commments(@PathVariable Long post_id){
        return ResponseEntity.ok()
                .body(commentService.findCommentsByPostId(post_id));
    }

    //댓글 저장
    @PostMapping("comment")
    public ResponseEntity<Long> saveComment(@RequestBody CommentForm commentForm){
        Post post = postRepository.findOne(commentForm.getPost_id());
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setContent(commentForm.getContent());
        return ResponseEntity.ok()
                .body(commentService.save(comment));
    }
}
