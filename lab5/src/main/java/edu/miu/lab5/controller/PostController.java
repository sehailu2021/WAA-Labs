package edu.miu.lab5.controller;

import edu.miu.lab5.domain.Comment;
import edu.miu.lab5.domain.Post;
import edu.miu.lab5.domain.dto.PostDto;
import edu.miu.lab5.service.CommentService;
import edu.miu.lab5.service.PostService;
import edu.miu.lab5.service.UserService;
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

    @Autowired
    CommentService commentService;

//    @GetMapping
//    public List<PostDto> getAll(){
//        return postService.findAll();
//
//    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id){
        return postService.findById(id);

    }

//    @GetMapping("/{title}")
//    public List<PostDto> findByTitle(@PathVariable String title){
//        return postService.findByTitle(title);
//
//    }

//    @PostMapping
//    public void savePost( long id,@RequestBody Post post){
//        postService.save(id,post);
//    }
//
//    @PutMapping("/{pId}")
//    public void updatePost(@PathVariable long pId, @RequestBody Post post){
//        postService.update(pId,post);
//    }
//
//    @DeleteMapping("/{pId}")
//    public void deletePost(@PathVariable long id, @PathVariable long pId){
//        postService.delete(id,pId);
//    }

    @GetMapping("{id}/comments")
    public List<Comment> getAll(@PathVariable long id){
        return commentService.getAllComments();

    }

//    @GetMapping("{id}/comments/{cId}")
//    public Comment getCommentById(@PathVariable long id,@PathVariable long cId){
//        return commentService.getCommentById(id,cId);
//
//    }

//    @GetMapping("/comments/{cId}")
//    public List<Comment> getByPostId(@PathVariable long cId){
//        return commentService.getByPostId( cId);
//
//    }

    @PostMapping("/comments")
    public void save(long id,Comment comment){
        commentService.addComment(id,comment);
    }


}
