package com.example.lab5.controller;
import com.example.lab5.entity.Comment;
import com.example.lab5.entity.Post;
import com.example.lab5.entity.dto.PostDto;
import com.example.lab5.service.PostService;
import com.example.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;


    @GetMapping
    public List<PostDto> getPostByUserId(@PathVariable long id){
        return userService.findByUserId(id);
    }
    @GetMapping("/{pId}")
    public Post getPostById(@PathVariable long id, @PathVariable long pId){
        return userService.findByUserIdAndPostId(id,pId);
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

//    @DeleteMapping("/{pId}")
//    public void deletePost(@PathVariable long id, @PathVariable long pId){
//        postService.delete(id,pId);
//    }

    @GetMapping("/{cId}/comments")
    public List<Comment> getByPostId(@PathVariable long cId){
        return postService.getByPostId( cId);

    }

    @PostMapping("/comments")
    public void save(long id,Comment comment){
        postService.addComment(id,comment);
    }


}
