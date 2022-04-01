package com.example.lab1.service.impl;

import com.example.lab1.domain.Post;
import com.example.lab1.domain.dto.PostDto;
import com.example.lab1.repo.PostRepo;
import com.example.lab1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;
    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) modelMapper.map(postRepo.findAll(),PostDto.class);
    }

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id),PostDto.class);
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);

    }

    @Override
    public void update(long id, Post p) {
        postRepo.update(id,p);
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);

    }
}
