package com.example.lab5.controller;
import com.example.lab5.entity.Comment;
import com.example.lab5.entity.Post;

import com.example.lab5.entity.dto.PostDto;
import com.example.lab5.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public  PostDto findById(@PathVariable long id){
        return  postService.findById(id);

    }

    @PostMapping
    public void savePost( long id,@RequestBody Post post){
        postService.save(id,post);
    }

    @PutMapping("/{pId}")
    public void updatePost(@PathVariable long pId, @RequestBody Post post){
        postService.update(pId,post);
    }


    @GetMapping("{pId}/comments")
    public List<Comment> getByPostId(@PathVariable long pId){
        return postService.getByPostId( pId);

    }

    @PostMapping("/comments")
    public void save(long id,Comment comment){
        postService.addComment(id,comment);
    }


}
