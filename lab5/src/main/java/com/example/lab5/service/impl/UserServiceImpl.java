package com.example.lab5.service.impl;

import com.example.lab5.entity.Post;
import com.example.lab5.entity.User;
import com.example.lab5.entity.dto.PostDto;
import com.example.lab5.entity.dto.UserDto;
import com.example.lab5.helper.ListMapper;
import com.example.lab5.repository.PostRepo;
import com.example.lab5.repository.UserRepository;
import com.example.lab5.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;


    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper<User, UserDto> listMapperUserToUserDto;
    @Autowired
    ListMapper<Post, PostDto> listMapperPostToPostDto;


    @Override
    public void save(User u) {
        userRepo.save(u);

    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);

    }

    @Override
    public void deletePost(long id, long pId) {
        var user = userRepo.getById(id);
        var post = postRepo.getById(pId);

    }
    @Override
    public UserDto getById(long id) {
        return modelMapper.map(userRepo.getById(id), UserDto.class);
    }
    @Override
    public List<UserDto> getAll() {
        return (List<UserDto>) listMapperUserToUserDto.mapList(userRepo.findAll(),new UserDto());
    }

    @Override
    public List<PostDto> findByUserId(long id) {
        var user = userRepo.getById(id);
        return (List<PostDto>) listMapperPostToPostDto.mapList(user.getPosts(),new PostDto());
    }

    @Override
    public Post findByUserIdAndPostId(long id, long pId) {
        return userRepo.findByUserIdAndPostId(id,pId);
    }
}

