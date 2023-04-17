package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.demo.model.Prenotazione;

public class PrenotazioniConfiguration {
	@Configuration
	@PropertySource("classpath:application.properties")
	public class PrenotazioneConfiguration {
		@Bean("CustomPrenotazione")
		@Scope("prototype")
		public Prenotazione customPrenotazione() {
			return new Prenotazione();
		}

//		@Bean("ParamsPrenotazione")
//		@Scope("prototype")
//		public Prenotazione paramsPrenotazione(Utente utente, Postazione p, LocalDate data) {
//			return new Prenotazione( utente,  p,  data);
//		}
}
}
