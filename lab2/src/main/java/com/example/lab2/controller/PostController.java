package com.example.lab2.controller;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class PostController {

    @Autowired
    PostService postService;


    @GetMapping("/{id}/posts")
    public List<Post> findById(@PathVariable long id){
        return postService.findByUserId(id) ;

    }
    @GetMapping("/posts/{title}")
    public List<User> findByPostTitle(@PathVariable String title){
        return postService.findByPostTitle(title);

    }


    @PostMapping("/{id}")
    public void savePost(@PathVariable long id,@RequestBody Post p ){
        postService.save(id,p);

    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable long id,@PathVariable int index, @RequestBody Post p){
        postService.update(id,p);

    }

    @DeleteMapping("/{id}/{pId}")
    public void deletePost(@PathVariable long id, @PathVariable long pId){
        postService.delete(id, pId);

    }


}
