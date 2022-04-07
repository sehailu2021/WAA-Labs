package com.example.lab2.service.impl;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.helper.ListMapper;
import com.example.lab2.repo.PostRepo;
import com.example.lab2.repo.UserRepo;
import com.example.lab2.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToPostDto;


    @Override
    public List<PostDto> findByTitle(String title) {

        return (List<PostDto>) listMapperPostToPostDto.mapList(postRepo.findByTitle(title),new PostDto());
    }

    @Override
    public List<PostDto> findByUserId(long id) {
        var user = userRepo.getById(id);
        return (List<PostDto>) listMapperPostToPostDto.mapList(user.getPosts(),new PostDto());
    }

    @Override
    public PostDto findByUserIdAndPostId(long id, long pId) {
        return modelMapper.map(postRepo.findByUserIdAndPostId(id,pId),PostDto.class);
    }


    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.getById(id),PostDto.class);
    }


    @Override
    public void save(long id, Post p) {
        var user =userRepo.getById(id);
        user.getPosts().add(p);
        postRepo.save(p);
    }

    @Override
    public void delete(long id, long pId) {
       var user = userRepo.getById(id);
       var post = postRepo.getById(pId);
       user.getPosts().remove(post);

    }

    @Override
    public void update(long id, Post p) {
        var post = postRepo.getById(id);
        post.setTitle(p.getTitle());
        post.setAuthor(p.getAuthor());
        post.setContent(p.getContent());


    }

}
