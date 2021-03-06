package com.example.lab5.controller;
import com.example.lab5.entity.Post;
import com.example.lab5.entity.User;
import com.example.lab5.entity.dto.PostDto;
import com.example.lab5.entity.dto.UserDto;
import com.example.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  //    @ExecutionTime
 //    @LogMe
    @Autowired
  UserService userService;
   @GetMapping
    public List<UserDto> getAllUser(){return userService.getAll();
    }

//    @LogMe
//    @ExecutionTime
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id) {
        return userService.getById(id);
    }
//
//    @GetMapping("/posts/{num}")
//    public List<UserDto> getUsers( @PathVariable int num){
//       return postService.findByPostSize(num);
//    }

//    @GetMapping("/{id}/posts/{title}")
//    public List<UserDto> getUsersByPostTitle( @PathVariable(value = "id") long id ,@PathVariable(value = "title") String title){
//        return postService.findByPostTitle(id,title);
//    }
    @GetMapping
    public List<PostDto> getPostByUserId(@PathVariable long id){
        return userService.findByUserId(id);
    }

    @GetMapping("/{pId}")
    public Post getPostById(@PathVariable long id, @PathVariable long pId){
        return userService.findByUserIdAndPostId(id,pId);
    }

    @PostMapping()
    public void save(User u){
        userService.save(u);
    }

    @DeleteMapping
    public void delete(long id){
        userService.delete(id);
    }
}
