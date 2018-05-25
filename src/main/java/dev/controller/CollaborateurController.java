package dev.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.entities.Collaborateur;
import dev.entities.Role;
import dev.repository.CollaborateurRepository;

@RestController()
@CrossOrigin
@RequestMapping("/collaborateurs")
public class CollaborateurController {

	final String API_URL = "http://app-3d0a5967-9429-444f-907d-cd29c4ee0f0c.cleverapps.io/collegues";

	@Autowired
	private CollaborateurRepository collabRepo;

	@GetMapping
	public List<Collaborateur> getVersion() {
		return this.collabRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ajouterCollab() {

		collabRepo.deleteAll();
		RestTemplate rt = new RestTemplate();
		Collaborateur[] response = rt.getForObject(API_URL, Collaborateur[].class);

		Stream.of(response).forEach(c -> {
			c.setJourCongePaye(25);
			c.setJourRTTEmploye(6);
			c.setJourRTTEmployeur(6);
			if (c.getSubalternes().isEmpty()) {
				c.setRole(Role.EMPLOYE);
			} else {
				c.setRole(Role.MANAGER);
			}
			collabRepo.save(c);
		});
		return ResponseEntity.ok(response);
	}
}
