package com.example.lab2.controller;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAllPost(){
        return postService.getAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable long id){
        var post = postService.getById(id) ;
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public void savePost(@RequestBody Post p){
        postService.save(p);

    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable long id, @RequestBody Post p){
        postService.update(id,p);

    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id){
        postService.delete(id);

    }


}
