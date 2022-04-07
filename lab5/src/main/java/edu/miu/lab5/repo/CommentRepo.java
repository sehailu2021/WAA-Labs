package com.example.lab2.repo;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

  @Query( "select c from Comment c where c.post.id =:id")
    List<Comment> getByPostId (long id);

}
