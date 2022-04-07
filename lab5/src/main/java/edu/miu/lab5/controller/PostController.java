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
@RequestMapping("/api/v1/users/{id}/posts")
public class PostController {
    @Autowired
     PostService postService;
    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;


    @GetMapping
    public List<PostDto> getPostByUserId(@PathVariable long id){
        return postService.findByUserId(id);
    }
    @GetMapping("/{pId}")
    public PostDto getPostById(@PathVariable long id, @PathVariable long pId){
        return postService.findByUserIdAndPostId(id,pId);
    }


//    @GetMapping("/{title}")
//    public List<PostDto> findByTitle(@PathVariable String title){
//        return postService.findByTitle(title);
//
//    }

    @PostMapping
    public void savePost( long id,@RequestBody Post post){
        postService.save(id,post);
    }

    @PutMapping("/{pId}")
    public void updatePost(@PathVariable long pId, @RequestBody Post post){
        postService.update(pId,post);
    }

    @DeleteMapping("/{pId}")
    public void deletePost(@PathVariable long id, @PathVariable long pId){
        postService.delete(id,pId);
    }

    @GetMapping("/{cId}/comments")
    public List<Comment> getByPostId(@PathVariable long cId){
        return commentService.getByPostId( cId);

    }

    @PostMapping("/comments")
    public void save(long id,Comment comment){
        commentService.addComment(id,comment);
    }


}
