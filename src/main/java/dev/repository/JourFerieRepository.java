package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entities.JourFerie;

public interface JourFerieRepository extends JpaRepository<JourFerie, Integer> {
	JourFerie findById(Integer id);
}
