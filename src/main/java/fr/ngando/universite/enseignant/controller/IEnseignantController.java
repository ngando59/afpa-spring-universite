package fr.ngando.universite.enseignant.controller;

import org.springframework.ui.Model;

import fr.ngando.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {

	public String deleteEnseignant(Model model, Integer id);

	public String enseignant(Model model, Integer id);

	public String enseignants(Model model);

	public String formAddEnseignant(Model model);

	public String formUpdateEnseignant(Model model, Integer id);

	public String insertEnseignant(Model model, Enseignant enseignant);

	public String updateEnseignant(Model model, Enseignant enseignant);
}
