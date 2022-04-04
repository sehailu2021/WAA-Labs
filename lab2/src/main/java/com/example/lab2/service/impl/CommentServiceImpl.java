package com.example.lab2.service.impl;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.repo.CommentRepo;
import com.example.lab2.repo.PostRepo;
import com.example.lab2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;


    @Override
    public void addComment(long id,Comment c) {
        var post = postRepo.getById(id);
        post.getComments().add(c);
    }


    @Override
    public List<Comment> getByPostId(long id) {
        return commentRepo.getByPostId(id);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepo.findAll();
    }
}
