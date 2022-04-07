package com.example.lab2.service;

import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(User u);

    void delete(long id);

    UserDto getById(long id);

    List<UserDto> getAll();

    List<UserDto> findByPostSize(int n);

    List<UserDto> findByPostTitle(String title);


}
