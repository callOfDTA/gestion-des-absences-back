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

// TODO: Auto-generated Javadoc
/**
 * The Class JourFerieController.
 */
@RestController()
@CrossOrigin
@RequestMapping("/feries")
public class JourFerieController {

	/** The jf repo. */
	@Autowired
	private JourFerieRepository jfRepo;

	/**
	 * Gets the list jour ferie.
	 *
	 * @return the list jour ferie
	 */
	@GetMapping
	public List<JourFerie> getListJourFerie() {
		return this.jfRepo.findAll();
	}

	/**
	 * Jour ferie par id.
	 *
	 * @param ferieId
	 *            the ferie id
	 * @return the jour ferie
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JourFerie ferieParId(@PathVariable("id") Integer ferieId) {
		return jfRepo.findById(ferieId);
	}

	/**
	 * Suppression jour ferie par id.
	 *
	 * @param ferieId
	 *            the ferie id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void suppressionJourFerieParId(@PathVariable("id") Integer ferieId) {
		jfRepo.delete(jfRepo.findById(ferieId));
	}

	/**
	 * Ajout jour ferie.
	 *
	 * @param nouvJf
	 *            the nouv jf
	 * @return the response entity
	 */
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

	/**
	 * Modification jour ferie.
	 *
	 * @param nouvJf
	 *            the nouv jf
	 * @param id
	 *            the id
	 * @return the response entity
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificationJourFerie(@RequestBody JourFerie nouvJf, @PathVariable("id") int id) {

		JourFerie jf = jfRepo.findById(id);

		LocalDate tmp = LocalDate.now();
		LocalDate date = LocalDate.parse(nouvJf.getDate(), DateTimeFormatter.ISO_DATE);

		if (date.isBefore(tmp)) {
			return ResponseEntity.badRequest()
					.body("Erreur : La date de début doit être au moins supérieur d'un jour au jour actuel");
		}

		if (!jf.getDate().equals(nouvJf.getDate())) {
			jf.setDate(nouvJf.getDate());
		}

		if (!jf.getCommentaire().equals(nouvJf.getCommentaire())) {
			jf.setCommentaire(nouvJf.getCommentaire());
		}

		jfRepo.save(jf);
		return ResponseEntity.ok(jf);
	}
}
