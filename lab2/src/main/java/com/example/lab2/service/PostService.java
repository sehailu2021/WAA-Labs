package com.example.lab2.service;


import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto findById(long id);

    void saveByUserId(long id, Post p);

    void save(Post post);

//  void deleteByUserId(long id, long Pid);
    void delete(long id);

    void update(long id,  Post p);

    List<PostDto> findAll();


    List<PostDto> findByTitle(String title);

    List<PostDto> findByUserId(long id);

    PostDto findByUserIdAndPostId(long id, long pId);


}
