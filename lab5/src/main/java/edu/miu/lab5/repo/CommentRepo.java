package edu.miu.lab5.repo;

import edu.miu.lab5.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

  @Query( "select c from Comment c where c.post.id =:id")
    List<Comment> getByPostId (long id);

}
