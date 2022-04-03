package com.example.lab2.service;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;

import java.util.List;

public interface CommentService {

    void addComment(Comment c);

    List<Comment> getComments ();
}
