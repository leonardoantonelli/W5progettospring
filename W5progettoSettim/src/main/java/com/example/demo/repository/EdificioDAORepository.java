package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Edificio;
import com.example.demo.model.Prenotazione;

public interface EdificioDAORepository  extends CrudRepository<Prenotazione, Long>{
	public List<Edificio> findByNome(String username);
	public List<Edificio> findByCittàAndNome(String uername, String lastname);
}
