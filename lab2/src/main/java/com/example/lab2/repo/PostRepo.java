package com.example.lab2.repo;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
//    @Query( "select p from Post p  where p.title =:title")
//       List<Post> findByUserId(String title);

//    @Query(value = "SELECT * FROM  post  WHERE title = title ",nativeQuery = true)
//      List<Post> getPostByTitle(String title);

    List<Post> findByUserId(long id);
}


