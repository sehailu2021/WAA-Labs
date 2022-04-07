package edu.miu.lab5.repo;

import edu.miu.lab5.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

     AppUser findByUserName(String name);

    @Query("select u from AppUser u where u.posts.size >=: n")
     List<AppUser> findByPostSize(int n);

    @Query("select p.user" + " from Post p where p.title =:title")
    List<AppUser> findByPostTitle(String title);


}
