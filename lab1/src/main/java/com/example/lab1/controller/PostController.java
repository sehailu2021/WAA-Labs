package com.example.lab1.controller;

import com.example.lab1.domain.Post;
import com.example.lab1.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

   private PostService postService ;
   public PostController(PostService postService){
       this.postService = postService;
   }

   @GetMapping
   public List<Post> findAllProduct(){
       return postService.findAll();

    }
   @GetMapping("/{id}")
    public ResponseEntity<Post> findProductById(@PathVariable long id){
       var post = postService.findById(id) ;
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
