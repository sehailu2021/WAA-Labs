package com.example.lab2.controller;

import com.example.lab2.aspect.annotation.ExecutionTime;
import com.example.lab2.aspect.annotation.LogMe;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.UserDto;
import com.example.lab2.service.PostService;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

//    @ExecutionTime
    @GetMapping("/users")
//    @LogMe
    public List<UserDto> getAllUser(){
        System.out.println("From Controller");
        return userService.getAll();
    }

//    @LogMe
//    @ExecutionTime
    @GetMapping("/users/{id}")
    public UserDto getById(@PathVariable long id){
        return userService.getById(id);
    }


    @GetMapping("/users/posts/{num}")
    public List<UserDto> getUsers( @PathVariable int num){
       return userService.findByPostSize(num);
    }


    @GetMapping("posts/{title}")
    public List<Post> findByTitle(@PathVariable String title){
       return postService.findByTitle(title) ;

    }

    @PostMapping("/users")
    public void save(User u){
        userService.save(u);
    }

    @DeleteMapping("/users")
    public void delete(long id){
        userService.delete(id);
    }
}
