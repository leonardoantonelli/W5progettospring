package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.model.Postazione;
import com.example.demo.model.Prenotazione;
import com.example.demo.model.User;
import com.example.demo.repository.PrenotazioneDAORepository;

public class PrenotazioneService {

	@Autowired
	private PrenotazioneDAORepository repo;

	@Autowired
	@Qualifier("ParamsPrenotazione")
	private ObjectProvider<Prenotazione> paramsPrenotazioneProvider;

	@Autowired
	PrenotazioneDAORepository prenotazioneDAORepository;
	public void insertPrenotazione(Prenotazione u) {
	//	repo.save(u);
	}
	//non funziona tanto 
	// da rivedere boh
	public void createPrenotazione(User user, Postazione postazione, LocalDate data) {
		Prenotazione u = paramsPrenotazioneProvider.getObject(user, postazione, data);
		//non funziona findByDataBetween
		List<Prenotazione> dataList= prenotazioneDAORepository.findByDataBetween(data,data.plusDays(1),postazione);
		if (!dataList.isEmpty() ) {
	
			System.out.println("La postazione risulta occupata. selezionare un altra data");
		} else {
			
			List<Prenotazione> uList= prenotazioneDAORepository.findByDataUtente(data,user);
			if(uList.size()<1) {
					insertPrenotazione(u);
				
			}else {System.out.println("errore");}
		
		}
	}
	//copiato da progetto vecchio
//	public Prenotazione findPrenotazioneById(Long id) {
//		return repo.findById(id).get();
//	}
//
//	public List<Prenotazione> findAllPrenotazione() {
//		return (List<Prenotazione>) repo.findAll();
//	}
//
//	public void removePrenotazione(Long id) {
//		repo.deleteById(id);
//	}

//	public void updatePrenotazione(Prenotazione u) {
//		repo.save(u);
//	}

}
