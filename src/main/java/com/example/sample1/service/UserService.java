package com.example.sample1.service;


import com.example.sample1.model.User;
import com.example.sample1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    public List<User> getAllUsers() {
        return userRepository.selectAllUsers();
    }
    public User getUserByUserId(String userId) { // get 메서드야 postid 줄게 id에 해당되는 글 가져와
        return userRepository.selectUserByUserId(userId);
    }
    public void removePost(String userId) {
        userRepository.deleteUser(userId);
    }
    public User setUser(User user) {
        if (getUserByUserId(user.getUserId()) == null) {
            String encodingPwd = passwordEncoder.encode(user.getPwd());
            user.setPwd(encodingPwd);
            userRepository.insertUser(user);
            return user;
        }
        return null;
    }
    public User updateUser(User userInput) {
        User user = userRepository.selectUserByUserId(userInput.getUserId());
        user.setUserId(userInput.getUserId());
        user.setPwd(userInput.getPwd());
        user.setName(userInput.getName());
        userRepository.updateUser(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.selectUserByUserId(userId);
        return user;
    }
}
