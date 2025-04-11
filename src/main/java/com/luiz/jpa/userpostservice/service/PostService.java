package com.luiz.jpa.userpostservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luiz.jpa.userpostservice.model.Post;
import com.luiz.jpa.userpostservice.model.User;
import com.luiz.jpa.userpostservice.repositories.PostRepository;

@Service
public class PostService {

    private final PostRepository repo;

    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public Post create(Post post, User user)
    {
        post.setUser(user);
        return repo.save(post);
    }

    public Page<Post> getPostByUserId(Long userId, Pageable pageable)
    {
        return repo.findByUserId(userId, pageable);
        
    }

    

}
