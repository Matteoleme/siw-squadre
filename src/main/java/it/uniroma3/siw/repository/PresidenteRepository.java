package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Presidente;

public interface PresidenteRepository extends CrudRepository<Presidente, Long> {

	public boolean existsByCf(String cf);
	
	@Query(value="SELECT p.* "
			+ "FROM presidente as p "
			+ "LEFT JOIN squadra as s ON p.id = s.presidente_id "
			+ "WHERE s.presidente_id IS NULL", nativeQuery=true)
	public Iterable<Presidente>findPresidentiLiberi();
}
