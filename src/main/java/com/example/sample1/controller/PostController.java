package com.example.sample1.controller;

import com.example.sample1.model.Post;
import com.example.sample1.model.User;
import com.example.sample1.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;

@Slf4j
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public String viewAllPosts(Model model) {
        List<Post> allPosts = postService.getAllPosts();
        model.addAttribute("allPosts", allPosts);
        return "post/postAll";
    }

    @RequestMapping("/posts/{postId}")
    public String viewPostById(Model model, @PathVariable int postId) {
        Post postById = postService.getPostById(postId);
        model.addAttribute("postById", postById);
        return "post/postDetail";
    }

    @RequestMapping("/posts/delete/{postId}")
    public String removePost(@PathVariable int postId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Post postById = postService.getPostById(postId);
        if (user.getUserId().equals(postById.getUser_userId())) {
            postService.removePost(postId);
            return "redirect:/posts";
        }
        model.addAttribute("err", "동일한 사용자만 게시글을 삭제 할수있습니다.");
        return "post/postErr";
    }

    @GetMapping("/posts/add")
    public String PostView() {
        return "post/postAdd";
    }

    @PostMapping("/posts/add")
    public String AddPost(Model model, Post post) {
        Post post1 = postService.setPost(post);
        model.addAttribute("post", post1);
        return "redirect:/posts";
    }

    @GetMapping("/posts/update/{postId}")
    public String updatePost(Model model, @PathVariable int postId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Post postById = postService.getPostById(postId);
        if (user.getUserId().equals(postById.getUser_userId())) {
            model.addAttribute("postById", postById);
            return "post/postUpdate";
        }
        model.addAttribute("err", "동일한 사용자만 게시글을 수정할수있습니다.");
        return "post/postErr";
    }


    @RequestMapping("/posts/update/{postId}")
    public String updatePost(Model model, @PathVariable int postId, Post post, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Post postById = postService.getPostById(post.getPostId());
        if (user.getUserId().equals(postById.getUser_userId())) {
            model.addAttribute("postById", postById);
            model.addAttribute("update", postService.updatePost(post));
            return "redirect:/posts/{postId}";
        }
        return "redirect:/posts";
    }
}

