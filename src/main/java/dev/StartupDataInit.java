package dev;

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

		Collaborateur collab1 = new Collaborateur(Role.EMPLOYE, "OSS117", "Bonisseurt De la Batte", "Hubert",
				"hubert.bonisseur@espion.fr", "combat", "1918/06/14", Sexe.male, "DGSE",
				"http://www.programme-television.org/news-tv/OSS-117-Le-Caire-nid-d-espions-C8-Le-show-de-Jean-Dujardin-4484285",
				subalterne1, "Espionnage Français", 20, 20, 50);

		Collaborateur collab2 = new Collaborateur(Role.EMPLOYE, "A007", "Bond", "James", "james.bond@espion.uk",
				"shaker", "1937/11/07", Sexe.male, "MI7",
				"http://www.deslettres.fr/wp-content/uploads/2013/09/Sean-Connery-pas-envie-de-celebrer-les-50-ans-de-James-Bond_reference.png",
				subalterne2, "Espionnage Anglais", 5, 5, 20);

		Collaborateur collab3 = new Collaborateur(Role.ADMINISTRATEUR, "S117", "Unknown", "John", "john117@soldat.us",
				"shaker", "2503/08/19", Sexe.male, "SPARTAN",
				"https://vignette.wikia.nocookie.net/halo/images/e/e5/John-117_H2A_transparant.png/revision/latest?cb=20141231173055",
				subalterne3, "Militaire", 1, 1, 3);

		Collaborateur collab4 = new Collaborateur(Role.MANAGER, "N17", "Antonova", "Natacha",
				"natacha.antonova@espion.ru", "shaker", "1946/07/31", Sexe.female, "KGB",
				"http://4.bp.blogspot.com/-Ol-DfJ1cgec/Tr0VYmCtiBI/AAAAAAAAAZU/cU1jzf56I-M/s640/61623_127880617264130_114664605252398_167802_2603692_n+-+Copie+%25282%2529.jpg",
				subalterne3, "Espionnage Russe", 0, 1, 1);

		if (this.collaborateurRepo.count() <= 0) {
			this.collaborateurRepo.save(collab1);
			this.collaborateurRepo.save(collab2);
			this.collaborateurRepo.save(collab3);
			this.collaborateurRepo.save(collab4);
		}

		if (this.absenceRepo.count() <= 0) {
			this.absenceRepo.save(new Absence("2018-05-05", "2018-05-12", CongeEnum.RTT, "VACANCES !!!",
					StatutEnum.EN_ATTENTE_VALIDATION, collab1));
			this.absenceRepo.save(new Absence("2018-06-02", "2018-06-15", CongeEnum.CONGE_PAYE, "Pitié, je me meurs",
					StatutEnum.INITIALE, collab1));
			this.absenceRepo.save(new Absence("2018-09-05", "2018-09-10", CongeEnum.CONGE_SANS_SOLDE,
					"Allons drager la donzelle", StatutEnum.REJETEE, collab1));
			this.absenceRepo.save(new Absence("2018-03-05", "2018-03-9", CongeEnum.CONGE_PAYE,
					"Allons siroter un cockail martini", StatutEnum.VALIDEE, collab2));
			this.absenceRepo.save(new Absence("2018-07-19", "2018-07-26", CongeEnum.CONGE_SANS_SOLDE,
					"Petit repos à Londre", StatutEnum.EN_ATTENTE_VALIDATION, collab2));
			this.absenceRepo.save(new Absence("2018-12-24", "2018-12-26", CongeEnum.CONGE_SANS_SOLDE,
					"Petite pause entre 2 fights contre des convenants", StatutEnum.INITIALE, collab3));
		}
	}
}
