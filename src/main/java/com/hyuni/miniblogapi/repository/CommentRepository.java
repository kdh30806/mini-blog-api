package com.hyuni.miniblogapi.repository;

import com.hyuni.miniblogapi.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public Long save(Comment comment){
        em.persist(comment);
        return comment.getId();
    }
    public List<Comment> findCommentsByPostId(Long post_id){
        return em.createQuery("select c from Comment c where post_id = :post_id", Comment.class)
                .setParameter("post_id", post_id)
                .getResultList();
    }
}


