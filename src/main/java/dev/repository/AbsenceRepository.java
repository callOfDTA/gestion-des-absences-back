package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entities.Absence;
import dev.entities.CongeEnum;
import dev.entities.StatutEnum;


public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
	List<Absence> findByCollaborateurMatricule(String matricule);

	List<Absence> findByTypeConge(CongeEnum typeConge);

	Absence findById(Integer id);

	List<Absence> findByStatut(StatutEnum statut);
}
