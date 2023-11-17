package com.example.sample1.service;

import com.example.sample1.model.Post;
import com.example.sample1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public List<Post> getAllPosts() {
        return postRepository.selectAllPosts();
    }
    public Post getPostById(int postId) { // get 메서드야 postid 줄게 id에 해당되는 글 가져와
        return postRepository.selectPostById(postId);
    }
    public void removePost(int postId) {
        postRepository.deletePost(postId);
    }
    public Post setPost(Post post) {
        postRepository.insertPost(post);
        return post;
    }
    public Post updatePost(Post post) {
        Post post1 = postRepository.selectPostById(post.getPostId());
        post1.setTitle(post.getTitle());
        post1.setBody(post.getBody());
        post1.setLikes(post.getLikes());
        postRepository.updatePost(post1);
        return post1;
    }
}
