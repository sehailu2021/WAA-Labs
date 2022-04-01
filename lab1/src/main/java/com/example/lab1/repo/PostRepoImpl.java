package com.example.lab1.repo;

import com.example.lab1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{
    private static List<Post> posts;
    private static int postId = 200;

    static {
       posts = new ArrayList<>();

        Post p1 = new Post(100,"spring","spring-boot","serk");
        Post p2 = new Post(101, "javascript", "node","kal");

        posts.add(p1);
        posts.add(p2);
    }


    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream().filter(p->p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Post p) {
        p.setId(postId);
        postId++;
        posts.add(p);

    }

    @Override
    public void update(long id, Post p) {
      Post postToUpdate = findById(id);
        postToUpdate.setTitle(p.getTitle());
        postToUpdate.setContent(p.getTitle());
        postToUpdate.setAuthor(p.getAuthor());

    }

    @Override
    public void delete(long id) {
        var postToDelete = posts.stream().filter(p->p.getId()==id).findFirst().get();
        posts.remove(postToDelete);
    }
}

