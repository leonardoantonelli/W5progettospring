package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.UtenteService;
@Component 
public class UserRunnale implements ApplicationRunner{

	@Autowired UtenteService utenteService;
	@Override
	public void run (ApplicationArguments args) {
	System.out.println("Run..");
	//Test di tutte le funzionalità richieste:
	
	utenteService.createFakeUser();
	}

}