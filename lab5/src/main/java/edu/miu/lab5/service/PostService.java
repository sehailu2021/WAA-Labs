package edu.miu.lab5.service;;
import edu.miu.lab5.domain.Post;
import edu.miu.lab5.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto findById(long id);

    List<PostDto> findAll();

    void save(long id, Post p);

    void delete(long id, long Pid);

    void update(long id, Post p);


    List<PostDto> findByTitle(String title);

    List<PostDto> findByUserId(long id);

    PostDto findByUserIdAndPostId(long id, long pId);


}
