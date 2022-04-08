package com.example.lab5.service;

import com.example.lab5.entity.Comment;
import com.example.lab5.entity.Post;
import com.example.lab5.entity.dto.PostDto;
import com.example.lab5.entity.dto.UserDto;

import java.util.List;

public interface PostService {

    PostDto findById(long id);

    void save(long id, Post p);

    void update(long id, Post p);


    List<PostDto> findByTitle(String title);

    List<UserDto> findByPostSize(int n);

    List<UserDto> findByPostTitle(long id,String title);


    void addComment(long id, Comment c);

    List<Comment> getByPostId(long id);

    List<Comment> getComments ();

}
