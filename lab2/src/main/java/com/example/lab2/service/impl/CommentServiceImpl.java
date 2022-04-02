package com.example.lab2.service.impl;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.repo.CommentRepo;
import com.example.lab2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;


    @Override
    public void addComment(Comment c) {
        commentRepo.save(c);
    }
}
