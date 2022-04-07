package edu.miu.lab5.controller;

import edu.miu.lab5.domain.Comment;
import edu.miu.lab5.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAll(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getById(@PathVariable long id){
        return commentService.findById(id);
    }

}
