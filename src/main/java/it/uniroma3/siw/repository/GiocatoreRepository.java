package it.uniroma3.siw.repository;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Giocatore;

public interface GiocatoreRepository extends CrudRepository<Giocatore, Long> {

	boolean existsByNomeAndCognomeAndDataDiNascita(String nome, String cognome, LocalDate dataDiNascita);
}
