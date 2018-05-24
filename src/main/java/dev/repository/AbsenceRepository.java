package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entities.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
	List<Absence> findByCollaborateurMatricule(String matricule);

	Absence findById(Integer id);
}
