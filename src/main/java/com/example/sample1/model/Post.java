package com.example.sample1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private Integer postId;
    private String title;
    private String body;
    private Integer likes;
    private String user_userId;
}
