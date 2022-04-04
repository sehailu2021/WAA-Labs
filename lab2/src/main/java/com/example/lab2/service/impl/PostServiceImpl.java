package com.example.lab2.service.impl;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.repo.PostRepo;
import com.example.lab2.repo.UserRepo;
import com.example.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;


    @Override
    public List<Post> findByUserId(long id) {
        var user = userRepo.getById(id);
        return user.getPosts();
    }

    @Override
    public List<Post> findByTitle(String title) {
        return postRepo.findByTitle(title);
    }

    @Override
    public List<User> findByPostTitle(String title) {
        return postRepo.findByPostTitle(title);
    }

    @Override
    public void save(long id, Post p) {
        var user =userRepo.getById(id);
        user.getPosts().add(p);
        postRepo.save(p);
    }

    @Override
    public void delete(long id, long pId) {
       var user = userRepo.getById(id);
       var post = postRepo.getById(pId);
       user.getPosts().remove(post);

    }

    @Override
    public void update(long id, Post p) {
        var post = postRepo.getById(id);
        post.setTitle(p.getTitle());
        post.setAuthor(p.getAuthor());
        post.setContent(p.getContent());


    }



}
