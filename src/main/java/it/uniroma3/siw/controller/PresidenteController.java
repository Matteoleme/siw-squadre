package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.controller.validator.PresidenteValidator;
import it.uniroma3.siw.model.Presidente;
import it.uniroma3.siw.repository.PresidenteRepository;
import jakarta.validation.Valid;

@Controller
public class PresidenteController {

	@Autowired
	PresidenteRepository presidenteRepository;
	@Autowired
	PresidenteValidator presidenteValidator;
	
	@GetMapping("/admin/formAggiungiPresidente")
	public String formNuovoPresidente(Model model) {
		model.addAttribute("presidente", new Presidente());
		return "admin/formAggiungiPresidente.html";
	}
	
	@PostMapping("/admin/aggiungiPresidente")
	public String aggiungiNuovoPresidente(@Valid @ModelAttribute("presidente") Presidente presidente, BindingResult bindingResult, Model model) {
		
		this.presidenteValidator.validate(presidente, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.presidenteRepository.save(presidente);
			model.addAttribute("presidente", presidente);
			return "admin/presidente.html";
		}
		else {
			model.addAttribute("messaggioErrore", "Questa presidente già esiste");
			return "admin/formAggiungiPresidente.html";
		}
	}
	
	@GetMapping("/admin/presidente/{id}")
	public String showPresidente(@PathVariable("id") Long id, Model model) {
		model.addAttribute("presidente", this.presidenteRepository.findById(id).get());
		return "admin/presidente.html";
	}
}
