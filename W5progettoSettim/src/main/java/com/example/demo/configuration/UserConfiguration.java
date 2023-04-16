package com.example.demo.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.example.demo.model.User;
import com.github.javafaker.Faker;

public class UserConfiguration {

	@Bean("CustomUser")
	@Scope("prototype")
	public User customUser() {
		return new User();
	}
	
	@Bean("FakeUser")
	@Scope("prototype")
	public User fakeUser() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		User u = new User();
		u.setName(fake.name().firstName());
		u.setEmail(u.getName() + "." + u.getId() + "@example.com");
		return u;
	}
}
