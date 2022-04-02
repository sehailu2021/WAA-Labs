package com.example.lab2.controller;

import com.example.lab2.domain.Comment;
import com.example.lab2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/add")
    public void save(Comment comment){
    }

}
