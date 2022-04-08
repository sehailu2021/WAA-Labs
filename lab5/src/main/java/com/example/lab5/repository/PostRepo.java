package com.example.lab5.repository;
import com.example.lab5.entity.Comment;
import com.example.lab5.entity.Post;
import com.example.lab5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  PostRepo extends JpaRepository<Post,Long> {

    List<Comment> getByPostId(long id);

    List<Post> findByTitle(String title);

    @Query("select u from User u where u.posts.size=:n")
    List<User> findByPostSize(int n);

    @Query("select p.user from Post p where p.user.id=:id and p.title=:title")
    List<User> findByPostTitle(long id,String title);






}


