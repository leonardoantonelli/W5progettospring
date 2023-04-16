package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.model.User;
import com.example.demo.repository.UserJDBCDao;

public class UtenteService {

	@Autowired private UserJDBCDao repo;

	@Autowired @Qualifier("FakeUser") private ObjectProvider<User> fakeUserProvider; 
	

	public void createFakeUser() { 
		User u= fakeUserProvider.getObject();
		insertUser(u);
	}
	
	
	
	// JDBC method
	
	public void insertUser(User u) {
		repo.create(u);
		System.out.println("ho salvato");
	}
	
	public User findUserByID(Long id) {
		return repo.getById(id);
	}
	
	public List<User> findAllUser() {
		return (List<User>) repo.getAllUser();
	}
	
	public void removeUser(Long id) {
		repo.delete(id);
		//repo.deleteById(u.getId());
	}
	
	public void updateUser(User u) {
		repo.update(u);
	}
}
