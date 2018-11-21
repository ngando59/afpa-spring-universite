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

	private final static String PAGE_MATIERE = "Matiere";
	private final static String PAGE_MATIERES = "Matieres";
	public final static String PAGE = "page";
	public final static String MATIERE = "Matiere";
	public final static String MATIERES = "Matieres";

	@Autowired
	private IMatiereBusiness matiereBusiness;

	@Override
	@RequestMapping("/matiere")
	public String matiere(Model model, @RequestParam Integer id) {
		Matiere matiere = matiereBusiness.findOneById(id);
		List<Note> notes = matiereBusiness.findAllNotesByMatiere(matiere);
		model.addAttribute(PAGE, PAGE_MATIERE);
		model.addAttribute(MATIERE, matiere);
		model.addAttribute("notes", notes);
		return "matiere/matiere";
	}

	@Override
	@RequestMapping("/matieres")
	public String matieres(Model model) {

		List<Matiere> matieres = matiereBusiness.findAll();
		model.addAttribute(PAGE, PAGE_MATIERES);
		model.addAttribute(MATIERES, matieres);
		return "matiere/matieres";
	}

	@Override
	@RequestMapping("matiere/update")
	public String update(Model model, Integer id) {
		Matiere matiere = matiereBusiness.findOneById(id);
		List<Enseignant> enseignants = matiereBusiness.findAllEnseigant();
		model.addAttribute(PAGE, PAGE_MATIERE);
		model.addAttribute("enseignants", enseignants);
		model.addAttribute(MATIERE, matiere);
		return "matiere/update";
	}

	@Override
	@PostMapping("matiere/update")
	public String update(Model model, @ModelAttribute Matiere matiere) {
		matiereBusiness.update(matiere);
		return "redirect:/matieres";
	}

}
