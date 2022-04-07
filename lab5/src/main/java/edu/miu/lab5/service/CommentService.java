package edu.miu.lab5.service;

import edu.miu.lab5.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(long id);

    void addComment(long id, Comment c);

    List<Comment> getByPostId(long id);
//    Comment getCommentById(long pId,long id);

    List<Comment> getAllComments ();
}
