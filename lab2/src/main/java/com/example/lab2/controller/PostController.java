package com.example.lab2.controller;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.service.CommentService;
import com.example.lab2.service.PostService;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
     PostService postService;
    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;


    @GetMapping
    public  List<PostDto> getAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public  PostDto getById(@PathVariable long id){
        return postService.findById(id);
    }


//    @GetMapping
//    public List<PostDto> getPostByUserId(@PathVariable long id){
//        return postService.findByUserId(id);
//    }
//    @GetMapping("/{pId}")
//    public PostDto getPostById(@PathVariable long id, @PathVariable long pId){
//        return postService.findByUserIdAndPostId(id,pId);
//    }


//    @GetMapping("/{title}")
//    public List<PostDto> findByTitle(@PathVariable String title){
//        return postService.findByTitle(title);
//
//    }

    @PostMapping
    public void savePost( @RequestBody Post post){
        postService.save(post);
    }

    @PutMapping("/{pId}")
    public void updatePost(@PathVariable long pId, @RequestBody Post post){
        postService.update(pId,post);
    }
//
//    @DeleteMapping("/{pId}")
//    public void deletePost(@PathVariable long id, @PathVariable long pId){
//        postService.delete(id,pId);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        postService.delete(id);

    }

    @GetMapping("/{id}/comments")
    public List<Comment> getByPostId(@PathVariable long id){
        return commentService.getByPostId( id);

    }

    @PostMapping("/comments")
    public void save(long id,Comment comment){
        commentService.addComment(id,comment);
    }


}
