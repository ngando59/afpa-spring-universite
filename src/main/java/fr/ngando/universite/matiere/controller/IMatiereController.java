package fr.ngando.universite.matiere.controller;

import org.springframework.ui.Model;

import fr.ngando.universite.matiere.domain.Matiere;

public interface IMatiereController {
	public String matiere(Model model, Integer id);

	public String matieres(Model model);

	public String update(Model model, Integer id);

	public String update(Model model, Matiere matiere);
}
