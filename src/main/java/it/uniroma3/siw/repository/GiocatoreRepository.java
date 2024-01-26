package it.uniroma3.siw.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Giocatore;
import it.uniroma3.siw.model.Squadra;

public interface GiocatoreRepository extends CrudRepository<Giocatore, Long> {

	boolean existsByNomeAndCognomeAndDataDiNascita(String nome, String cognome, LocalDate dataDiNascita);
	
	List<Giocatore> findBySquadra(Squadra Squadra);
	
	@Query(value="SELECT * FROM public.giocatore "
			+ "WHERE giocatore.squadra_id is null", nativeQuery=true)
	public Iterable<Giocatore>findGiocatoriLiberi();
}
