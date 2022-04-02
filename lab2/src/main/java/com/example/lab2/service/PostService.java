package com.example.lab2.service;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostService {
    void save(Post u);

    void delete(long id);

    void update(long id, Post p);

    Post getById(long id);

    List<Post> getAll();

}
