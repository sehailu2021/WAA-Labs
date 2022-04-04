package com.example.lab2.service;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostService {
    void save(long id, Post p);

    void delete(long id, long Pid);

    void update(long id, Post p);


    List<Post> findByUserId(long id);

    List<Post> findByTitle(String title);

    List<User> findByPostTitle(String title);

}
