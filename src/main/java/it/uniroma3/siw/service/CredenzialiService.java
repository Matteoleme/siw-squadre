package it.uniroma3.siw.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.repository.CredenzialiRepository;
import jakarta.transaction.Transactional;

@Service
public class CredenzialiService {

	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	@Autowired
	protected CredenzialiRepository credentialsRepository;
	
	@Transactional
	public Credenziali getCredentials(Long id) {
		Optional<Credenziali> result = this.credentialsRepository.findById(id);
		return result.orElse(null);
	}

	@Transactional
	public Credenziali getCredenziali(String username) {
		Optional<Credenziali> result = this.credentialsRepository.findByUsername(username);
		return result.orElse(null);
	}
		
    @Transactional
    public Credenziali saveCredentials(Credenziali credenziali) {
        credenziali.setRuolo(Credenziali.DEFAULT_ROLE);
        credenziali.setPassword(this.passwordEncoder.encode(credenziali.getPassword()));
        return this.credentialsRepository.save(credenziali);
    }
}
