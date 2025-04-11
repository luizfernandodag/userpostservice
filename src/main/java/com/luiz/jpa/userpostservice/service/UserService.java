package com.luiz.jpa.userpostservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luiz.jpa.userpostservice.model.User;
import com.luiz.jpa.userpostservice.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository repo; 
    public UserService(UserRepository repo)
    {
        this.repo = repo;

    }

    public List<User> all()
    {
        return repo.findAll();

    }

    public User save(User u)
    {
        return repo.save(u);
    }

    public User findById(Long id)
    {
        return repo.findById(id).orElseThrow();

    }


}
