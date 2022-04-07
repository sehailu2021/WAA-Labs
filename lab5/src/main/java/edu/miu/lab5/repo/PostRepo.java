package com.example.lab2.repo;

import com.example.lab2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  PostRepo extends JpaRepository<Post,Long> {


    @Query ("select p from Post p where p.title =:title")
    List<Post> findByTitle(String title);

    @Query ("Select p from Post p where p.user.id=:id and p.id=:pId")
    Post findByUserIdAndPostId(long id, long pId);

//    @Query ("Select p from User u join " +
//            "Post p on(u.id = p.user.id) where u.id= :id and p.id=:pId")
//    Post findByUserIdAndPostId(long id, long pId);







}


