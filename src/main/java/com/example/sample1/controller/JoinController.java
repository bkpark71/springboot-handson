package com.example.sample1.controller;

import com.example.sample1.model.User;
import com.example.sample1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@Controller
public class JoinController {

    @Autowired
    private UserService userService;

    @GetMapping("user/join")
    public String join(){
        return "user/join";
    }

    @PostMapping("user/join")
    public String join(User userInput){
        User user = userService.setUser(userInput);
        return "redirect:/user/login";
    }

    @GetMapping("user/check")
    @ResponseBody
    public Boolean check(String userId) {
        User user = userService.getUserByUserId(userId);
        if (user != null) {
            return false;
        } return true;
    }
}
