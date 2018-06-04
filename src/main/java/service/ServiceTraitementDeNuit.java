package service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entities.Absence;
import dev.entities.Collaborateur;
import dev.entities.CongeEnum;
import dev.entities.StatutEnum;
import dev.repository.AbsenceRepository;
import dev.repository.CollaborateurRepository;

@Service
public class ServiceTraitementDeNuit {

	@Autowired
	private AbsenceRepository absenceRepo;

	@Autowired
	private CollaborateurRepository collabRepo;

	public ServiceTraitementDeNuit(AbsenceRepository absenceRepo, CollaborateurRepository collabRepo) {
		super();
		this.absenceRepo = absenceRepo;
		this.collabRepo = collabRepo;
	}

	Collaborateur collabSup;

	Absence absence;

	public void init() {

		validation();
	}

	public void validation() {
		List<Absence> listAbsenceInitiale = absenceRepo.findByStatut(StatutEnum.INITIALE);
		if (listAbsenceInitiale != null) {
			listAbsenceInitiale.forEach((abs -> {
				int nbDays = calculJourAbsence(abs);

				if (abs.getTypeConge() == CongeEnum.CONGE_PAYE) {
					if (abs.getCollaborateur().getJourCongePaye() - nbDays > 0) {
						abs.setStatut(StatutEnum.EN_ATTENTE_VALIDATION);
						this.absence = abs;
						absenceRepo.save(abs);
						findCollaborateur(abs.getCollaborateur());
					} else {
						abs.setStatut(StatutEnum.REJETEE);
						absenceRepo.save(abs);
					}
				}
				if (abs.getTypeConge() == CongeEnum.RTT_EMPLOYE) {
					if (abs.getCollaborateur().getJourRTTEmploye() - nbDays > 0) {
						abs.setStatut(StatutEnum.EN_ATTENTE_VALIDATION);
						absenceRepo.save(abs);
						findCollaborateur(abs.getCollaborateur());
					} else {
						abs.setStatut(StatutEnum.REJETEE);
						absenceRepo.save(abs);
					}
				}
			}));
		}
	}

	public int calculJourAbsence(Absence abs) {
		if (abs != null) {
			int nbDays = 0;
			LocalDate debut = LocalDate.parse(abs.getDateDebut(), DateTimeFormatter.ISO_DATE);
			LocalDate fin = LocalDate.parse(abs.getDateFin(), DateTimeFormatter.ISO_DATE);
			int val = Period.between(debut, fin).getDays();
			for (int i = 0; i < val; i++) {
				LocalDate date = debut;
				if (date.getDayOfYear() < fin.getDayOfYear()) {
					date = date.plusDays(i);
					date.getDayOfWeek();
					date.getDayOfWeek();
					if (date.getDayOfWeek() != DayOfWeek.SUNDAY && date.getDayOfWeek() != DayOfWeek.SATURDAY) {
						nbDays++;
					}
				}
			}
			return nbDays;
		} else {
			return 0;
		}
	}

	public Collaborateur findCollaborateur(Collaborateur col) {
		this.collabSup = null;
		List<Collaborateur> listCollaborateurs = collabRepo.findAll();
		if (listCollaborateurs != null) {
			listCollaborateurs.forEach(cols -> {
				cols.getSubalternes().forEach(sub -> {
					if (sub == col.getMatricule()) {
						this.collabSup = cols;
					} else {
						this.absence.setStatut(StatutEnum.VALIDEE);
						this.absenceRepo.save(this.absence);
					}
				});
			});
			email(this.collabSup);
			return this.collabSup;
		} else {
			return null;
		}

	}

	public void email(Collaborateur collab) {
		if (collab != null) {
			System.out.println("coucou");
		}

	}
}
