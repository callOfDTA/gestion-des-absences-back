package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entities.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {
	Collaborateur findCollaborateurByMatricule(String matricule);
}
