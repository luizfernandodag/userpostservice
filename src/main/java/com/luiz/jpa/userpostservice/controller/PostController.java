package com.luiz.jpa.userpostservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.jpa.userpostservice.model.Post;
import com.luiz.jpa.userpostservice.service.PostService;
import com.luiz.jpa.userpostservice.service.UserService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    } 

    @PostMapping("/user/{userId}")   
    public Post createPost(@PathVariable Long userId, @RequestBody Post post)
    {
        return this.postService.create(post, userService.findById(userId));

    }

    @GetMapping("/user/{userId}")  
    public Page<Post> getPosts(@PathVariable Long userId, @RequestParam(value="0", defaultValue = "0") String page, @RequestParam(defaultValue = "5") String size)
    {
        return postService.getPostByUserId(userId, PageRequest.of(Integer.parseInt(page), Integer.parseInt(size)));
    }
}
