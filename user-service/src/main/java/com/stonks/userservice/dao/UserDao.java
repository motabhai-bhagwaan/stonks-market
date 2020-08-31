package com.stonks.userservice.dao;

import org.springframework.stereotype.Repository;

import com.stonks.userservice.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
    public User findByUsername(String username);
}

