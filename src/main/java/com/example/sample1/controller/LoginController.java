package com.example.sample1.controller;

import com.example.sample1.model.User;
import com.example.sample1.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }
}
//      초기 로그인
//    @PostMapping("/user/login")
//    public String login(User userInput, HttpSession session) {
//        System.out.println(userInput.toString());
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

