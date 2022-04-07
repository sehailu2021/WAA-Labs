package com.example.lab2.service;

import com.example.lab2.domain.Comment;

import java.util.List;

public interface CommentService {

    void addComment(long id,Comment c);

    List<Comment> getByPostId(long id);

    List<Comment> getComments ();
}
