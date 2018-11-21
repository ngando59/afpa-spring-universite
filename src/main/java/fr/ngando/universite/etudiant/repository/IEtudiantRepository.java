package fr.ngando.universite.etudiant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ngando.universite.etudiant.domain.Etudiant;

@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Integer> {

	List<Etudiant> findBySexe(Character sexe);
}