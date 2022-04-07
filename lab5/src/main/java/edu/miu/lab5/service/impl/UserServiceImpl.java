package com.example.lab2.service.impl;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.domain.dto.UserDto;
import com.example.lab2.helper.ListMapper;
import com.example.lab2.repo.UserRepo;
import com.example.lab2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<User, UserDto> listMapperUserToUserDto;

    @Autowired
    private UserRepo userRepo;


    @Override
    public void save(User u) {
        userRepo.save(u);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);

    }

    @Override
    public UserDto getById(long id) {
        return modelMapper.map(userRepo.getById(id),UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        return  (List<UserDto>) listMapperUserToUserDto.mapList(userRepo.findAll(),new UserDto());
    }

    @Override
    public List<UserDto> findByPostSize(int n) {
        return (List<UserDto>) listMapperUserToUserDto.mapList(userRepo.findByPostSize(n),new UserDto() );
    }

    @Override
    public List<UserDto> findByPostTitle(String title) {
        return (List<UserDto>) listMapperUserToUserDto.mapList(userRepo.findByPostTitle(title),new UserDto());
    }


}

