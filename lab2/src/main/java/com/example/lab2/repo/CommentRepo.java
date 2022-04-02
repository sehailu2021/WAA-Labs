package com.example.lab2.repo;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

//    @Query(value = "SELECT c FROM Comment c WHERE c.post.id =:id")

}
