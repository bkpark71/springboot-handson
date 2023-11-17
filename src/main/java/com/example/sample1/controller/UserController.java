//package com.example.sample1.controller;
//
//import com.example.sample1.model.User;
//import com.example.sample1.service.UserService;
//import jakarta.servlet.http.HttpSession;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@Slf4j
//@Controller
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/user/login")
//    public String login() {
//        return "user/login";
//    }
//    @PostMapping("/user/login")
//    public String login(User userInput, HttpSession session) {
//        String userId = userInput.getUserId();
//        String pwd = userInput.getPwd();
//        User user = userService.getUserByUserId(userId);
//        if (user != null) {
//            if (user.getPwd().equals(pwd)) {
//                session.setAttribute("user", user);
//                return "redirect:/posts";
//            }
//        }
//        return "redirect:/user/login";
//    }
//    @GetMapping("/user/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/user/login";
//    }
//
//    @GetMapping("user/join")
//    public String join(){
//        return "user/join";
//    }
//
//    @PostMapping("user/join")
//    public String join(User userInput){
//        User user = userService.setUser(userInput);
//        return "redirect:/user/login";
//    }
//
//    @GetMapping("user/check")
//    @ResponseBody
//    public Boolean check(String userId) {
//        User user = userService.getUserByUserId(userId);
//        if (user != null) {
//            return false;
//        } return true;
//    }
//}
