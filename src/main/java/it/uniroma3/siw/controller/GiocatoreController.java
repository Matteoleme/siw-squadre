package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.controller.validator.GiocatoreValidator;
import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Giocatore;
import it.uniroma3.siw.model.Presidente;
import it.uniroma3.siw.model.Squadra;
import it.uniroma3.siw.repository.GiocatoreRepository;
import it.uniroma3.siw.repository.PresidenteRepository;
import it.uniroma3.siw.service.CredenzialiService;
import jakarta.validation.Valid;

@Controller
public class GiocatoreController {
	@Autowired
	GiocatoreRepository giocatoreRepository;
	@Autowired
	CredenzialiService credenzialiService;
	@Autowired
	PresidenteRepository presidenteRepository;
	@Autowired
	GiocatoreValidator giocatoreValidator;

	@GetMapping("/admin/formAggiungiGiocatore")
	public String formAggiungiGiocatore(Model model) {
		model.addAttribute("giocatore", new Giocatore());
		return "admin/formAggiungiGiocatore.html";
	}

	@PostMapping("/admin/aggiungiGiocatore")
	public String aggiungiGiocatore(@Valid @ModelAttribute("giocatore") Giocatore giocatore,
			BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			this.giocatoreRepository.save(giocatore);
			model.addAttribute("giocatore", giocatore);
			return "admin/giocatore.html";
		} else {
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

	// questi due metodi consentono al presidente di aggiungere un nuovo giocatore nel sistema e metterlo nella sua squadra
	@GetMapping("/presidente/formAggiungiGiocatore")
	public String formAggiungiGiocatorePresidente(Model model) {
		model.addAttribute("giocatore", new Giocatore());
		return "presidente/formAggiungiGiocatore.html";
	}

	@PostMapping("/presidente/aggiungiGiocatore")
	public String aggiungiGiocatorePresidente(@Valid @ModelAttribute("giocatore") Giocatore giocatore,
			BindingResult bindingResult, Model model) {
		this.giocatoreValidator.validate(giocatore, bindingResult);
		if (!bindingResult.hasErrors()) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
			// poi devo avere i dettagli della squadra dove aggiungere il giocatore tramite
			// le informazioni del presidente loggato
			Presidente presidente = this.presidenteRepository.findByNomeAndCognome(credenziali.getUtente().getNome(),
					credenziali.getUtente().getCognome());
			Squadra squadra = presidente.getSquadra();
			giocatore.setSquadra(squadra);
			this.giocatoreRepository.save(giocatore);
			model.addAttribute("giocatore", giocatore);
			return "presidente/giocatore.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo giocatore esiste già");
//			model.addAttribute("giocatore", new Giocatore());
			return "presidente/formAggiungiGiocatore.html";
		}
	}

	// Questi due metodi consentono di inserire un giocatore già presente nel sistema nella squadra del presidente
	@GetMapping("/presidente/scegliGiocatore")
	public String scegliGiocatorePresidente(Model model) {
		// alla pagina devo passare tutti i giocatori che non sono collegati a nessuna
		// squadra
		model.addAttribute("giocatori", this.giocatoreRepository.findGiocatoriLiberi());
		model.addAttribute("message", "Giocatori senza squadra");
		return "presidente/giocatori.html";
	}

	@GetMapping("/presidente/aggiungiGiocatoreSquadra/{idGiocatore}")
	public String addGiocatoreASquadra(@PathVariable("idGiocatore") Long idGiocatore, Model model) {
		// per farmi restituire i dettagli del presidente loggato
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
		// poi devo avere i dettagli della squadra dove aggiungere il giocatore tramite
		// le informazioni del presidente loggato
		Presidente presidente = this.presidenteRepository.findByNomeAndCognome(credenziali.getUtente().getNome(),
				credenziali.getUtente().getCognome());
		Squadra squadra = presidente.getSquadra();
		Giocatore nuovoGiocatore = this.giocatoreRepository.findById(idGiocatore).get();
		nuovoGiocatore.setSquadra(squadra);
		this.giocatoreRepository.save(nuovoGiocatore);
		// ora passo tutti i giocatori della squadra del presidente
		model.addAttribute("message", "Giocatori della sua squadra");
		model.addAttribute("giocatori", this.giocatoreRepository.findBySquadra(squadra));
		return "presidente/giocatori.html";
	}
	
	@GetMapping("/presidente/mostraSquadra")
	public String mostraSquadraPresidente(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
		
		Presidente presidente = this.presidenteRepository.findByNomeAndCognome(credenziali.getUtente().getNome(),
				credenziali.getUtente().getCognome());
		Squadra squadra = presidente.getSquadra();
		
		model.addAttribute("message", "Giocatori della sua squadra");
		model.addAttribute("giocatori", this.giocatoreRepository.findBySquadra(squadra));
		return "presidente/giocatori.html";
	}

}
