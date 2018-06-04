package dev.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.entities.JourFerie;
import dev.repository.JourFerieRepository;

@RestController()
@CrossOrigin
@RequestMapping("/feries")
public class JourFerieController {
	@Autowired
	private JourFerieRepository jfRepo;

	@GetMapping
	public List<JourFerie> getListJourFerie() {
		return this.jfRepo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JourFerie absenceParId(@PathVariable("id") Integer ferieId) {
		return jfRepo.findById(ferieId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void suppressionabsenceParId(@PathVariable("id") Integer ferieId) {
		jfRepo.delete(jfRepo.findById(ferieId));
	}

	@RequestMapping(method = RequestMethod.POST, path = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ajoutJourFerie(@RequestBody JourFerie nouvJf) {

		LocalDate tmp = LocalDate.now();
		LocalDate date = LocalDate.parse(nouvJf.getDate(), DateTimeFormatter.ISO_DATE);

		if (date.isBefore(tmp)) {
			return ResponseEntity.badRequest()
					.body("Erreur : La date doit être au moins supérieur d'un jour au jour actuel");
		}

		jfRepo.save(nouvJf);
		return ResponseEntity.ok(nouvJf);
	}
}
