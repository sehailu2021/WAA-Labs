package edu.miu.lab5.service.impl;
import edu.miu.lab5.domain.Comment;
import edu.miu.lab5.repo.CommentRepo;
import edu.miu.lab5.repo.PostRepo;
import edu.miu.lab5.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;


    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.getById(id);
    }

    @Override
    public void addComment(long id, Comment c) {
        var post = postRepo.getById(id);
        post.getComments().add(c);
    }

    @Override
    public List<Comment> getByPostId(long id) {
        return commentRepo.getByPostId(id);
    }

//    @Override
//    public Comment getCommentById( long pId, long id) {
//        var post = postRepo.getById(pId);
//        return post.getComments();
//    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }
}
