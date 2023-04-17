package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Postazione postazione;
	@ManyToOne
	private User utente;
	private LocalDate data;
}
