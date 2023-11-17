package com.example.sample1.repository;

import com.example.sample1.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface PostRepository {
    List<Post> selectAllPosts();
    Post selectPostById(int postId);
    void deletePost(int postId);
    int insertPost(Post post);
    void updatePost(Post post);
}
