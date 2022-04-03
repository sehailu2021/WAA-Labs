package com.example.lab2.controller;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class PostController {

    @Autowired
    PostService postService;


    @GetMapping("/{id}/posts")
    public List<Post> findById(@PathVariable long id){
        return postService.findByUserId(id) ;

    }

    @PostMapping("/{id}")
    public void savePost(@RequestBody Post p, @PathVariable long id){
        postService.save(p,id);

    }

    @PutMapping("/{id}/{index}")
    public void updatePost(@PathVariable long id,@PathVariable int index, @RequestBody Post p){
        postService.update(id,index,p);

    }

    @DeleteMapping("/{id}/{pId}")
    public void deletePost(@PathVariable long id, @PathVariable long pId){
        postService.delete(id, pId);

    }


}
