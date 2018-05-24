package dev;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.entities.Absence;
import dev.entities.Collaborateur;
import dev.entities.CongeEnum;
import dev.entities.Role;
import dev.entities.Sexe;
import dev.entities.StatutEnum;
import dev.repository.AbsenceRepository;
import dev.repository.CollaborateurRepository;

@Component
public class StartupDataInit {

	@Autowired
	CollaborateurRepository collaborateurRepo;

	@Autowired
	AbsenceRepository absenceRepo;

	@EventListener(ContextRefreshedEvent.class)
	public void initialiser() {
		ArrayList<String> subalterne1 = new ArrayList<String>();
		subalterne1.add("S117");
		ArrayList<String> subalterne2 = new ArrayList<String>();
		subalterne2.add("A007");
		subalterne2.add("S117");
		subalterne2.add("O000");
		ArrayList<String> subalterne3 = new ArrayList<String>();

		Collaborateur collab1 = new Collaborateur(Role.EMPLOYE, "OSS177", "Bonisseurt De la Batte", "Hubert",
				"hubert.bonisseur@espion.fr", "combat", "1918/06/14", Sexe.male, "DGSE", "../images/OSS117.jpg",
				subalterne1, "Espionnage Français", 50, 30);

		Collaborateur collab2 = new Collaborateur(Role.EMPLOYE, "A007", "Bond", "James", "james.bond@espion.uk",
				"shaker", "1937/11/07", Sexe.male, "MI7", "../images/007.jpg", subalterne2, "Espionnage Anglais", 10,
				20);

		Collaborateur collab3 = new Collaborateur(Role.ADMINISTRATEUR, "S117", "Unknown", "John", "john117@soldat.us",
				"shaker", "2503/08/19", Sexe.male, "SPARTAN", "../images/S117.jpg", subalterne3, "Militaire", 2, 8);

		Collaborateur collab4 = new Collaborateur(Role.MANAGER, "N17", "Antonova", "Natacha",
				"natacha.antonova@espion.ru", "shaker", "1946/07/31", Sexe.female, "KGB", "../images/N17.jpg",
				subalterne3, "Militaire", 1, 2);

		if (this.collaborateurRepo.count() <= 0) {
			this.collaborateurRepo.save(collab1);
			this.collaborateurRepo.save(collab2);
			this.collaborateurRepo.save(collab3);
			this.collaborateurRepo.save(collab4);
		}

		ZoneId zoneFr = ZoneId.of("UTC+1");
		ZoneId zoneUK = ZoneId.of("UTC+0");
		ZoneId zoneUSNYC = ZoneId.of("UTC-5");

		// ZonedDateTime.of(Année, Mois, Jour, Heure, Minute, Seconde,
		// Nanoseconde, Zone);
		if (this.absenceRepo.count() <= 0) {
			this.absenceRepo.save(new Absence(ZonedDateTime.of(2018, 6, 5, 00, 00, 00, 0000, zoneFr),
					ZonedDateTime.of(2018, 6, 10, 00, 00, 00, 00, zoneFr), CongeEnum.RTT, "VACANCES !!!",
					StatutEnum.EN_ATTENTE_VALIDATION, collab1));
			this.absenceRepo.save(new Absence(ZonedDateTime.of(2018, 5, 15, 00, 00, 00, 0000, zoneFr),
					ZonedDateTime.of(2018, 5, 30, 00, 00, 00, 00, zoneFr), CongeEnum.CONGE_PAYE, "Pitié, je me meurs",
					StatutEnum.INITIALE, collab1));
			this.absenceRepo.save(new Absence(ZonedDateTime.of(2018, 9, 2, 00, 00, 00, 0000, zoneFr),
					ZonedDateTime.of(2018, 9, 16, 00, 00, 00, 00, zoneFr), CongeEnum.CONGE_SS,
					"Allons drager la donzelle", StatutEnum.REJETEE, collab1));
			this.absenceRepo.save(new Absence(ZonedDateTime.of(1964, 12, 19, 00, 00, 00, 0000, zoneUK),
					ZonedDateTime.of(1964, 12, 26, 00, 00, 00, 00, zoneUK), CongeEnum.CONGE_PAYE,
					"Allons siroter un cockail martini", StatutEnum.VALIDEE, collab2));
			this.absenceRepo.save(new Absence(ZonedDateTime.of(1965, 1, 2, 00, 00, 00, 0000, zoneUK),
					ZonedDateTime.of(1965, 1, 10, 00, 00, 00, 00, zoneUK), CongeEnum.CONGE_SS, "Petit repos à Londre",
					StatutEnum.EN_ATTENTE_VALIDATION, collab2));
			this.absenceRepo.save(new Absence(ZonedDateTime.of(2018, 9, 21, 00, 00, 00, 0000, zoneUSNYC),
					ZonedDateTime.of(2543, 9, 23, 00, 00, 00, 00, zoneUSNYC), CongeEnum.CONGE_SS,
					"Petite pause entre 2 fights contre des convenants", StatutEnum.INITIALE, collab3));
		}
	}
}
