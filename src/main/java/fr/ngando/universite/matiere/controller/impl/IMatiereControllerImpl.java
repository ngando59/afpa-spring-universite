package fr.ngando.universite.matiere.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ngando.universite.enseignant.domain.Enseignant;
import fr.ngando.universite.matiere.business.IMatiereBusiness;
import fr.ngando.universite.matiere.controller.IMatiereController;
import fr.ngando.universite.matiere.domain.Matiere;
import fr.ngando.universite.note.domain.Note;

@Controller
public class IMatiereControllerImpl implements IMatiereController {

	@Autowired
	private IMatiereBusiness matiereBusiness;

	@Override
	@RequestMapping("/matiere")
	public String matiere(Model model, @RequestParam Integer id) {
		String page = "Matiere";
		Matiere matiere = matiereBusiness.findOneById(id);
		List<Note> notes = matiereBusiness.findAllNotesByMatiere(matiere);
		model.addAttribute("page", page);
		model.addAttribute("matiere", matiere);
		model.addAttribute("notes", notes);
		return "matiere/matiere";
	}

	@Override
	@RequestMapping("/matieres")
	public String matieres(Model model) {
		String page = "Matieres";
		List<Matiere> matieres = matiereBusiness.findAll();
		model.addAttribute("page", page);
		model.addAttribute("matieres", matieres);
		return "matiere/matieres";
	}

	@Override
	@RequestMapping("matiere/update")
	public String update(Model model, Integer id) {
		String page = "Matiere";
		Matiere matiere = matiereBusiness.findOneById(id);
		List<Enseignant> enseignants = matiereBusiness.findAllEnseigant();
		model.addAttribute("page", page);
		model.addAttribute("enseignants", enseignants);
		model.addAttribute("matiere", matiere);
		return "matiere/update";
	}

	@Override
	@PostMapping("matiere/update")
	public String update(Model model, @ModelAttribute Matiere matiere) {
		matiereBusiness.update(matiere);
		return "redirect:/matieres";
	}

}
