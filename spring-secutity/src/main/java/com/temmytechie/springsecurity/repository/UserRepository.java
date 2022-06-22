package com.temmytechie.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temmytechie.springsecurity.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String username);
}
