package it.uniroma3.siw.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import it.uniroma3.siw.model.Giocatore;
import it.uniroma3.siw.repository.GiocatoreRepository;

@Component
public class GiocatoreValidator implements org.springframework.validation.Validator {

	@Autowired
	GiocatoreRepository giocatoreRepository;
	@Override
	public void validate(Object o, Errors errors) {
		Giocatore giocatore = (Giocatore)o;
		if (giocatore.getNome()!=null && giocatoreRepository.existsByNomeAndCognomeAndDataDiNascita(giocatore.getNome(), giocatore.getCognome(), giocatore.getDataDiNascita())) {
			errors.reject("giocatore.duplicate");
		}
	}
	@Override
	public boolean supports(Class<?> aClass) {
		return Giocatore.class.equals(aClass);
	}

	

}
