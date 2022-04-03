package com.example.lab2.controller;

import com.example.lab2.aspect.annotation.ExecutionTime;
import com.example.lab2.aspect.annotation.LogMe;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.UserDto;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<UserDto> getAllUser(){
        return userService.getAll();
    }

    @LogMe
    @ExecutionTime
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id){
        return userService.getById(id);
    }


    @GetMapping("/posts/{num}")
    public List<UserDto> getUsers( @PathVariable int num){
       return userService.findByPostSize(num);
    }



    @PostMapping
    public void save(User u){
        userService.save(u);
    }
}
