package com.example.lab5.service.impl;
import com.example.lab5.entity.Comment;
import com.example.lab5.entity.Post;
import com.example.lab5.entity.dto.PostDto;
import com.example.lab5.helper.ListMapper;
import com.example.lab5.repository.CommentRepo;
import com.example.lab5.repository.PostRepo;
import com.example.lab5.repository.UserRepository;
import com.example.lab5.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;
//    @Autowired
//    ListMapper<User, UserDto> listMapperUserToUserDto;
    @Autowired
    ListMapper<Post, PostDto> listMapperPostToPostDto;

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.getById(id),PostDto.class);
    }

    @Override
    public void save(long id, Post p) {;
        var user = userRepo.getById(id);
        user.getPosts().add(p);
    }


    @Override
    public void update(long id, Post p) {

    }

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapperPostToPostDto.mapList(postRepo.findAll(),new PostDto());
    }

    @Override
    public List<PostDto> findByTitle(String title) {
        return (List<PostDto>) listMapperPostToPostDto.mapList(postRepo.findByTitle(title),new PostDto());
    }



    @Override
    public void addComment(long id, Comment c) {
        var post  = postRepo.getById(id);
        post.getComments().add(c);

    }

    @Override
    public List<Comment> getByPostId(long id) {
        return postRepo.getByPostId(id);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepo.findAll();
    }
}
