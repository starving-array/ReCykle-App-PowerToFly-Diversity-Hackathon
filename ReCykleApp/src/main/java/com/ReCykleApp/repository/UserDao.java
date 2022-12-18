package com.ReCykleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ReCykleApp.module.User;


public interface UserDao extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	public User findByContact(String contact);
	


}