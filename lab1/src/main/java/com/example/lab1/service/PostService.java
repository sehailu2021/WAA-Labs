package com.example.lab1.service;

import com.example.lab1.domain.Post;
import com.example.lab1.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto  findById(long id);

    void save(Post p);

    void update(long id, Post p);

    void delete(long id);

}
