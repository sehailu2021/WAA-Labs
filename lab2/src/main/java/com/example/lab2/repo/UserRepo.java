package com.example.lab2.repo;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {


    @Query(value = "select * from User u where u.posts.size >= num",nativeQuery = true)
    List<User> findUserByPostSize(int num);

    @Query(value = "select * from User u where u.post.title  = title",nativeQuery = true)
    List<User> findUserByPostTitle(String title);


//  @Query(value = "select * from User u where u.id: id",nativeQuery = true)
//    List<Post> findPostsByUserId(long id);


}
