package com.example.lab2.repo;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    //    @Query(value = "select * from Post p  where p.: id",nativeQuery = true)
//    List<Post> findPostsByUserId(long id);

    @Query(value = "SELECT * FROM Post p WHERE p.title = :title ",nativeQuery = true)
      List<Post> getPostByTitle(String title);
}


