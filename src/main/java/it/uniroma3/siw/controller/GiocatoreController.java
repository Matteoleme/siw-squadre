package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Giocatore;
import it.uniroma3.siw.repository.GiocatoreRepository;
import jakarta.validation.Valid;

@Controller
public class GiocatoreController {
	@Autowired
	GiocatoreRepository giocatoreRepository;
	
	@GetMapping("/admin/formAggiungiGiocatore")
	public String formAggiungiGiocatore(Model model) {
		model.addAttribute("giocatore", new Giocatore());
		return "admin/formAggiungiGiocatore.html";
	}
	
	@PostMapping("/admin/aggiungiGiocatore")
	public String aggiungiGiocatore(@Valid @ModelAttribute("giocatore")Giocatore giocatore, BindingResult bindingResult, Model model) {
		if(!bindingResult.hasErrors()) {
			this.giocatoreRepository.save(giocatore);
			model.addAttribute("giocatore", giocatore);
			return "admin/giocatore.html";
		}
		else {
			model.addAttribute("messaggioErrore", "Questo giocatore esiste già");
			return "admin/formAggiungiGiocatore.html";
		}
	}
	
	@GetMapping("/admin/mostraTuttiGiocatori")
	public String showGiocatori(Model model) {
		model.addAttribute("giocatori", this.giocatoreRepository.findAll());
		return "admin/giocatori.html";
	}
	
	@GetMapping("/admin/giocatore/{id}")
	public String showGiocatore(@PathVariable("id") Long id, Model model) {
		model.addAttribute("giocatore", giocatoreRepository.findById(id).get());
		return "admin/giocatore.html";
	}
}
