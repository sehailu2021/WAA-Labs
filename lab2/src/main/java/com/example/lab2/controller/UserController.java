package com.example.lab2.controller;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.UserDto;
import com.example.lab2.service.PostService;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

  //    @ExecutionTime
 //    @LogMe
   @GetMapping
    public List<UserDto> getAllUser(){return userService.getAll();
    }

//    @LogMe
//    @ExecutionTime
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @GetMapping("/posts/{num}")
    public List<UserDto> getUsers( @PathVariable int num){
       return userService.findByPostSize(num);
    }

    @GetMapping("/{id}/posts/{title}")
    public List<UserDto> getUsersByPostTitle( @PathVariable(value = "id") long id ,@PathVariable(value = "title") String title){
        return userService.findByPostTitle(id,title);
    }

    @PostMapping
    public void save(User u){
        userService.save(u);
    }

    @DeleteMapping
    public void delete(long id){
        userService.delete(id);
    }
}
