package fr.ngando.universite.etudiant.controller.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ngando.universite.etudiant.business.IEtudiantBusiness;
import fr.ngando.universite.etudiant.controller.IEtudiantController;
import fr.ngando.universite.etudiant.domain.Etudiant;
import fr.ngando.universite.note.domain.Note;

@Controller
public class EtudiantControllerImpl implements IEtudiantController {

	@Autowired
	private IEtudiantBusiness etudiantBusiness;

	@Override
	@RequestMapping("/etudiant/delete")
	public String delete(Model model, Integer id) {
		Etudiant etudiant = etudiantBusiness.findOneById(id);
		etudiantBusiness.delete(etudiant);
		return "redirect:/etudiants";
	}

	@Override
	@GetMapping("/etudiant")
	public String etudiant(Model model, Integer id) {
		String page = "Etudiant";
		Etudiant etudiant = etudiantBusiness.findOneById(id);
		List<Note> noteMoreThan10 = etudiantBusiness.findAllNoteMoreThan10(etudiant);
		model.addAttribute("page", page);
		model.addAttribute("etudiant", etudiant);
		model.addAttribute("noteMoreThan10", noteMoreThan10);
		return "etudiant/etudiant";
	}

	@Override
	@GetMapping("/etudiants")
	public String etudiants(Model model) {
		String page = "Etudiants";
		@SuppressWarnings("deprecation")
		Etudiant etudiant = new Etudiant(null, 10514, "Sparrow", "Jack", new Date(2000, 02, 14), 'M',
				"j.pirate@gmail.com", "Pacifique");
		List<Etudiant> etudiants = etudiantBusiness.findAll();
		model.addAttribute("page", page);
		model.addAttribute("etudiants", etudiants);
		model.addAttribute("etudiant", etudiant);
		return "etudiant/etudiants";
	}

	@Override
	@PostMapping("/etudiants")
	public String etudiants(Model model, @ModelAttribute Etudiant etudiant) {
		String message = etudiantBusiness.insert(etudiant);
		String page = "Etudiants";
		List<Etudiant> etudiants = etudiantBusiness.findAll();
		if (message.startsWith("[E]:")) {
			model.addAttribute("messageError", message.substring(4));
		} else if (message.startsWith("[S]:")) {
			model.addAttribute("messageSuccess", message.substring(4));
		}
		model.addAttribute("page", page);
		model.addAttribute("etudiants", etudiants);
		model.addAttribute("etudiant", etudiant);
		return "etudiant/etudiants";
	}

	@Override
	@PostMapping("/etudiant/update")
	public String update(Model model, @ModelAttribute Etudiant etudiant) {
		etudiantBusiness.update(etudiant);
		return "redirect:/etudiants";
	}

	@Override
	@GetMapping("/etudiant/update")
	public String update(Model model, Integer id) {
		String page = "Etudiant";
		Etudiant etudiant = etudiantBusiness.findOneById(id);
		model.addAttribute("page", page);
		model.addAttribute("etudiant", etudiant);
		return "etudiant/update";
	}

}
