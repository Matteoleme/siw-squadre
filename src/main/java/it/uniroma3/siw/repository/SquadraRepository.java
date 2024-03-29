package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Squadra;

public interface SquadraRepository extends CrudRepository<Squadra, Long> {

	boolean existsByNomeAndAnnoFondazione(String nome, Integer annoFondazione);
	
	boolean existsByNome(String nome);
	
}
