package dev.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.entities.Absence;
import dev.entities.Collaborateur;
import dev.entities.CongeEnum;
import dev.entities.Role;
import dev.entities.Sexe;
import dev.entities.StatutEnum;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void initialiser() {

		ZoneId zoneFr = ZoneId.of("UTC+1");

		ArrayList<String> subalterne = new ArrayList<String>();
		subalterne.add("A007");
		subalterne.add("S117");
		subalterne.add("A117");

		Collaborateur collab1 = new Collaborateur(Role.EMPLOYE, "OSS177", "Bonisseurt De la Batte", "Hubert",
				"hubert.bonisseur@espion.fr", "combat", "1918/06/14", Sexe.male, "DGSE", "../images/OSS117.jpg",
				subalterne, "Espionnage");
		Collaborateur collab2 = new Collaborateur(Role.EMPLOYE, "A007", "Bond", "James", "james.bond@espion.fr",
				"shaker", "1961/11/07", Sexe.male, "MI7", "../images/007.jpg", subalterne, "Espionnage");

		// ZonedDateTime.of(Année, Mois, Jour, Heure, Minute, Seconde,
		// Nanoseconde, Zone);
		Absence ab1 = new Absence(ZonedDateTime.of(2018, 06, 05, 00, 00, 00, 0000, zoneFr),
				ZonedDateTime.of(2018, 06, 10, 00, 00, 00, 00, zoneFr), CongeEnum.RTT, "VACANCES !!!",
				StatutEnum.EN_ATTENTE_VALIDATION, collab1);
		Absence ab2 = new Absence(ZonedDateTime.of(2018, 05, 15, 00, 00, 00, 0000, zoneFr),
				ZonedDateTime.of(2018, 05, 30, 00, 00, 00, 00, zoneFr), CongeEnum.CONGE_PAYE, "Pitié, je me meurs",
				StatutEnum.EN_ATTENTE_VALIDATION, collab2);

		em.persist(collab1);
		em.persist(collab2);

		em.persist(ab1);
		em.persist(ab2);

	}
}
