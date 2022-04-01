package com.example.lab1.repo;

import com.example.lab1.domain.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();

    Post  findById(long id);

    void save(Post p);

    void update(long id, Post p);

    void delete(long id);
}
