package com.example.lab2.controller;

import com.example.lab2.domain.Comment;
import com.example.lab2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{id}/posts")
public class CommentController {
    @Autowired
    CommentService commentService;

   @GetMapping("/{cId}/comments")
    public List<Comment> getByPostId(@PathVariable long cId){
        return commentService.getByPostId( cId);

    }

    @PostMapping("/comments")
    public void save(long id,Comment comment){
       commentService.addComment(id,comment);
    }

}
