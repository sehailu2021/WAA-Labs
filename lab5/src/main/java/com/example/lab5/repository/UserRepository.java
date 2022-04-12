package com.example.lab5.repository;
import com.example.lab5.entity.User;
import com.example.lab5.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("select p from Post p where p.user.id=:id")
    List<Post> findByUserId(long id);

      @Query("select p from Post p where p.user.id=:id and p.id=:pId")
           Post findByUserIdAndPostId(long id, long pId);

}
