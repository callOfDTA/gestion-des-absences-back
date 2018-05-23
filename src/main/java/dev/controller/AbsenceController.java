package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.entities.Absence;
import dev.repository.AbsenceRepository;

@RestController()
@CrossOrigin
@RequestMapping("/absences")
public class AbsenceController {

	@Autowired
	private AbsenceRepository absenceRepo;

	@GetMapping
	public List<Absence> getListAbsence() {
		return this.absenceRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, params = { "collaborateur" })
	@ResponseBody
	public List<Absence> absenceParCollaborateur(@RequestParam("collaborateur") String matricule) {
		return absenceRepo.findByCollaborateurMatricule(matricule);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Absence absenceParId(@PathVariable("id") Integer absenceId) {
		return absenceRepo.findById(absenceId);
	}

}
