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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.entities.Absence;
import dev.entities.CongeEnum;
import dev.entities.StatutEnum;
import dev.repository.AbsenceRepository;
import dev.repository.CollaborateurRepository;

@RestController()
@CrossOrigin
@RequestMapping("/absences")
public class AbsenceController {

	@Autowired
	private AbsenceRepository absenceRepo;

	@Autowired
	private CollaborateurRepository collabRepo;

	@GetMapping
	public List<Absence> getListAbsence() {
		return this.absenceRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, params = { "collaborateur" })
	@ResponseBody
	public List<Absence> absenceParCollaborateur(@RequestParam("collaborateur") String matricule) {
		return absenceRepo.findByCollaborateurMatricule(matricule);
	}

	@RequestMapping(method = RequestMethod.GET, params = { "conge" })
	@ResponseBody
	public List<Absence> absenceParConge(@RequestParam("conge") CongeEnum typeConge) {
		return absenceRepo.findByTypeConge(typeConge);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Absence absenceParId(@PathVariable("id") Integer absenceId) {
		return absenceRepo.findById(absenceId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void suppressionabsenceParId(@PathVariable("id") Integer absenceId) {
		absenceRepo.delete(absenceRepo.findById(absenceId));
	}

	@RequestMapping(method = RequestMethod.POST, path = "/{matricule}/nouvelle", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ajoutAbsence(@RequestBody Absence nouvAbs, @PathVariable("matricule") String matricule) {

		LocalDate tmp = LocalDate.now();
		LocalDate debut = LocalDate.parse(nouvAbs.getDateDebut(), DateTimeFormatter.ISO_DATE);
		LocalDate fin = LocalDate.parse(nouvAbs.getDateFin(), DateTimeFormatter.ISO_DATE);

		if (debut.isBefore(tmp)) {
			return ResponseEntity.badRequest()
					.body("Erreur : La date de début doit être au moins supérieur d'un jour au jour actuel");
		}
		if (fin.isBefore(debut) || fin.isEqual(debut)) {
			return ResponseEntity.badRequest().body("Erreur : La date de fin doit être supérieur à la date de début");
		}
		if (nouvAbs.getTypeConge().equals(CongeEnum.CONGE_SANS_SOLDE)
				&& (nouvAbs.getMotif() == null || nouvAbs.getMotif().equals(""))) {
			return ResponseEntity.badRequest()
					.body("Erreur : le type de congé est CONGE SANS SOLDE donc le motif est obligatoire");
		}

		nouvAbs.setStatut(StatutEnum.INITIALE);
		nouvAbs.setCollaborateur(collabRepo.findCollaborateurByMatricule(matricule));
		absenceRepo.save(nouvAbs);
		return ResponseEntity.ok(nouvAbs);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{matricule}/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificationAbsence(@RequestBody Absence nouvAbs,
			@PathVariable("matricule") String matricule, @PathVariable("id") int id) {

		Absence abs = absenceRepo.findById(id);

		LocalDate tmp = LocalDate.now();
		LocalDate debut = LocalDate.parse(nouvAbs.getDateDebut(), DateTimeFormatter.ISO_DATE);
		LocalDate fin = LocalDate.parse(nouvAbs.getDateFin(), DateTimeFormatter.ISO_DATE);

		if (debut.isBefore(tmp)) {
			return ResponseEntity.badRequest()
					.body("Erreur : La date de début doit être au moins supérieur d'un jour au jour actuel");
		}
		if (fin.isBefore(debut) || fin.isEqual(debut)) {
			return ResponseEntity.badRequest().body("Erreur : La date de fin doit être supérieur à la date de début");
		}
		if (nouvAbs.getTypeConge().equals(CongeEnum.CONGE_SANS_SOLDE)
				&& (nouvAbs.getMotif() == null || nouvAbs.getMotif().equals(""))) {
			return ResponseEntity.badRequest()
					.body("Erreur : le type de congé est CONGE SANS SOLDE donc le motif est obligatoire");
		}

		if (nouvAbs.getStatut().equals(StatutEnum.INITIALE) || nouvAbs.getStatut().equals(StatutEnum.REJETEE)) {
			if (!abs.getDateDebut().equals(nouvAbs.getDateDebut())) {
				abs.setDateDebut(nouvAbs.getDateDebut());
			}
			if (!abs.getDateFin().equals(nouvAbs.getDateFin())) {
				abs.setDateFin(nouvAbs.getDateFin());
			}
			if (!abs.getMotif().equals(nouvAbs.getMotif())) {
				abs.setMotif(nouvAbs.getMotif());
			}
			if (!abs.getTypeConge().equals(nouvAbs.getTypeConge())) {
				abs.setTypeConge(nouvAbs.getTypeConge());
			}
		} else {
			return ResponseEntity.badRequest()
					.body("Erreur : status de votre demande incorrect " + nouvAbs.getStatut());
		}

		absenceRepo.save(abs);
		return ResponseEntity.ok(abs);
	}
}
