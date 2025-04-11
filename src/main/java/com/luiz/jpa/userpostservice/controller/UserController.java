package com.luiz.jpa.userpostservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.jpa.userpostservice.model.User;
import com.luiz.jpa.userpostservice.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

private final UserService service;

public UserController(UserService service) {
    this.service = service;
}

@GetMapping 
public List<User> all()
{
    return this.service.all();
    
}


@PostMapping 
public User create(@RequestBody User u)
{

    return service.save(u);
    
}


}
