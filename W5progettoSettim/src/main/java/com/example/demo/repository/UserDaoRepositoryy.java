package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserDaoRepositoryy {
	public void create(User user);
	public void update(User user);
	public void delete(Long id);
	public User getById(Long id);
	public List<User> getAllUser(); 
}
