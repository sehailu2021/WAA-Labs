package com.example.lab2.repo;
import com.example.lab2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {


    @Query("select u from User u where u.posts.size >=: n")
     List<User> findByPostSize(int n);

    @Query("select p from Post p where p.user.id =:id and p.title=:title")
    List<User> findByPostTitle(long id, String title);


}
