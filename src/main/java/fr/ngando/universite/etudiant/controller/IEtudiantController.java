package fr.ngando.universite.etudiant.controller;

import org.springframework.ui.Model;

import fr.ngando.universite.etudiant.domain.Etudiant;

public interface IEtudiantController {
	public String delete(Model model, Integer id);

	public String etudiant(Model model, Integer id);

	public String etudiants(Model model);

	public String etudiants(Model model, Etudiant etudiant);

	public String update(Model model, Etudiant etudiant);

	public String update(Model model, Integer id);
}
