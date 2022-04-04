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


    @Query("select u from User u where u.posts.size >=: n")
     List<User> findByPostSize(int n);


}
