package com.example.lab5.service;
import com.example.lab5.entity.Post;
import com.example.lab5.entity.User;
import com.example.lab5.entity.dto.PostDto;
import com.example.lab5.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(User u);

    void delete(long id);

    void deletePost(long id, long Pid);

    UserDto getById(long id);

    List<UserDto> getAll();


    List<PostDto> findByUserId(long id);

    Post findByUserIdAndPostId(long id, long pId);


}
