package com.example.lab2.service.impl;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.repo.PostRepo;
import com.example.lab2.repo.UserRepo;
import com.example.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;


    @Override
    public void save(Post u) {
        postRepo.save(u);
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById(id);

    }

    @Override
    public void update(long id, Post p) {
        var toUpdate = postRepo.getById(id);
        toUpdate.setContent(p.getContent());
        toUpdate.setAuthor(p.getAuthor());
        toUpdate.setTitle(p.getTitle());

    }

    @Override
    public Post getById(long id) {
        return postRepo.getById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepo.findAll();
    }
}
