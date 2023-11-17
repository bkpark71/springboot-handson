package com.example.sample1.repository;


import com.example.sample1.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class PostRepositoryImpl implements PostRepository {
    private static Map<Integer, Post> posts = new HashMap<>();
    private static int seq = 0;
    public List<Post> selectAllPosts() {// 자바에서는 generic 타입으로 array 가 아닌 list를 사용한다.
        return new ArrayList<>(posts.values());
    }
    @Override
    public Post selectPostById(int postId) {
        return posts.get(postId);
    }
    @Override
    public void deletePost(int postId) {
        posts.remove(postId);
    }
    public int insertPost(Post post) {
        post.setPostId(++seq);
        posts.put(seq, post);
        return post.getPostId();
    }
    @Override
    public void updatePost(Post post) {
        posts.put(post.getPostId(), post);
    }
}
