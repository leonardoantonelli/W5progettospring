package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserJDBCDao implements UserDaoRepositoryy {
	
	@Autowired JdbcTemplate jdbc;
	
	/*
	 * public UserJDBCDao() { this.jdbc = new JdbcTemplate(); }
	 */

	@Override
	public void create(User user) {
		String sql = "INSERT INTO public.user (name, email) "
				   + "VALUES (?, ?, ?, ?, ?, ?)";
		jdbc.update(sql,
				user.getName(),
				user.getEmail());
					
		log.info("Utente " + user.getName() +" " + user.getEmail()  +" salvato nel DB!!!");
	}
	
	@Override
	public void update(User user) {
		String sql = "UPDATE public.user SET name = ?, lastname = ?, "
				+ "email = ?, age = ?, city = ?, password = ? WHERE id = ?";
		jdbc.update(sql, 
				user.getName(),
				
				user.getEmail(),
				
				user.getId());
		log.info("Utente " + user.getName() + " " + user.getId() + " modificato nel DB!!!");
	}
	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM public.user WHERE id = ?";
		jdbc.update(sql, id);
		log.info("Utente cancellato nel DB!!!");
	}

	@Override
	public User getById(Long id) {
		String sql = "SELECT * FROM public.user WHERE id = ?";
		User u = jdbc.queryForObject(sql, new UserRowMapper(), id);	
		return u;
	}

	@Override
	public List<User> getAllUser() {
		String sql = "SELECT * FROM public.user";
		List<User> lista = jdbc.query(sql, new UserRowMapper());
		return lista;
	}
}
