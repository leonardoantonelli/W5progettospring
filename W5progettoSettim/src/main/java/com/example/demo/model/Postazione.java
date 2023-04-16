package com.example.demo.model;

import com.example.demo.Enum.Tipologia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Entity
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
public class Postazione {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String codice;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private Tipologia tipologia;
	private int numeromax;
	private Boolean disponibilita;
	private Edificio edificio;
}
