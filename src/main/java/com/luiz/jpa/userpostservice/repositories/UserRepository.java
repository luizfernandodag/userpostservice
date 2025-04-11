package com.luiz.jpa.userpostservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiz.jpa.userpostservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
