package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.controller.validator.SquadraValidator;
import it.uniroma3.siw.model.Presidente;
import it.uniroma3.siw.model.Squadra;
import it.uniroma3.siw.repository.GiocatoreRepository;
import it.uniroma3.siw.repository.PresidenteRepository;
import it.uniroma3.siw.repository.SquadraRepository;
import jakarta.validation.Valid;

@Controller
public class SquadreController {
	
	@Autowired
	SquadraRepository squadraRepository;
	@Autowired
	GiocatoreRepository giocatoreRepository;
	@Autowired
	PresidenteRepository presidenteRepository;
	@Autowired
	SquadraValidator squadraValidator;
	
	// da togliere da qui!!!
	@GetMapping("/admin/index")
	public String adminIndex(Model model) {
		return "admin/index.html";
	}
	
	@GetMapping("/admin/formAggiungiSquadra")
	public String addSquad(Model model) {
		model.addAttribute("squadra", new Squadra());
		return "admin/formAggiungiSquadra.html";
	}
	
	@PostMapping("/admin/aggiungiSquadra")
	public String newSquadra(@Valid @ModelAttribute("squadra") Squadra squadra, BindingResult bindingResult, Model model) {
		// qui oltre a validare i dati in base alle annotazioni controlla anche i duplicati
		this.squadraValidator.validate(squadra, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.squadraRepository.save(squadra);
			model.addAttribute("squadra", squadra);				//crea questa view
			// mi da la lista di tutti i presidenti che non hanno già una squadra
			model.addAttribute("presidenti", this.presidenteRepository.findPresidentiLiberi());
			return "admin/aggiungiPresidente.html";
		} else {
			model.addAttribute("messaggioErrore", "Questa squadra esiste già");
			return "admin/formAggiungiSquadra.html";
		}
	}
	
	@GetMapping("/admin/aggiungiPresidente/{idPres}/{idSquad}")
	public String presidenteToAdd(@PathVariable("idPres") Long idPresidente, @PathVariable("idSquad") Long idSquadra, Model model) {
		Squadra squadra = this.squadraRepository.findById(idSquadra).get();
		Presidente presidente = this.presidenteRepository.findById(idPresidente).get();
		squadra.setPresidente(presidente);
		this.squadraRepository.save(squadra);
		model.addAttribute("squadra", squadra);
		return "squadra.html";
	}

	
	@GetMapping("/squadre")
	public String showSquads(Model model) {
		model.addAttribute("squadre", this.squadraRepository.findAll());
		return "squadre.html";
	}
	
	
}
