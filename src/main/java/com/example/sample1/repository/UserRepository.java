package com.example.sample1.repository;

import com.example.sample1.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    List<User> selectAllUsers();
    User selectUserByUserId(String userId);
    void deleteUser(String userId);
    int insertUser(User user);
    void updateUser(User user);
}
