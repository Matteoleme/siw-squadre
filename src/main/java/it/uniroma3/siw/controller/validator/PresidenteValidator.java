package it.uniroma3.siw.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Presidente;
import it.uniroma3.siw.repository.PresidenteRepository;

@Component
public class PresidenteValidator implements Validator {
	@Autowired
	PresidenteRepository presidenteRepository;
	
	@Override
	public void validate(Object o, Errors errors) {
		Presidente presidente = (Presidente)o;
		if (presidente.getCf()!=null && presidenteRepository.existsByCf(presidente.getCf())) {
			errors.reject("presidente.duplicate");
		}
	}
	@Override
	public boolean supports(Class<?> aClass) {
		return Presidente.class.equals(aClass);
	}
}
