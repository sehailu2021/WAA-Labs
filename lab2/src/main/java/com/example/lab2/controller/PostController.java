package com.example.lab2.controller;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users 
    }

    @DeleteMapping("/{id}/{pId}")
    public void deletePost(@PathVariable long id, @PathVariable long pId){
        postService.delete(id, pId);

    }


}
