package fr.ngando.universite.etudiant.controller.impl;

import java.util.Calendar;
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
	private final static String PAGE_ETUDIANT = "Etudiant";
	private final static String PAGE_ETUDIANTS = "Etudiants";
	public final static String ATTR_PAGE = "page";
	public final static String ATTR_ETUDIANT = "etudiant";
	public final static String ATTR_ETUDIANTS = "etudiants";
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
		Etudiant etudiant = etudiantBusiness.findOneById(id);
		List<Note> noteMoreThan10 = etudiantBusiness.findAllNoteMoreThan10(etudiant);
		model.addAttribute(ATTR_PAGE, PAGE_ETUDIANT);
		model.addAttribute(ATTR_ETUDIANT, etudiant);
		model.addAttribute("noteMoreThan10", noteMoreThan10);
		return "etudiant/etudiant";
	}

	@Override
	@GetMapping("/etudiants")
	public String etudiants(Model model) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2000);
		cal.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal.set(Calendar.DAY_OF_MONTH, 14);
		Date dateNaissance = cal.getTime();
		Etudiant etudiant = new Etudiant();
		etudiant.setNumEtudiant(10514);
		etudiant.setNom("Sparrow");
		etudiant.setPrenom("Jack");
		etudiant.setDateNaissance(dateNaissance);
		etudiant.setSexe('M');
		etudiant.setEmail("j.pirate@gmail.com");
		List<Etudiant> etudiants = etudiantBusiness.findAll();
		model.addAttribute(ATTR_PAGE, PAGE_ETUDIANTS);
		model.addAttribute(ATTR_ETUDIANTS, etudiants);
		model.addAttribute(ATTR_ETUDIANT, etudiant);
		return "etudiant/etudiants";
	}

	@Override
	@PostMapping("/etudiants")
	public String etudiants(Model model, @ModelAttribute Etudiant etudiant) {
		String message = etudiantBusiness.insert(etudiant);
		List<Etudiant> etudiants = etudiantBusiness.findAll();
		if (message.startsWith("[E]:")) {
			model.addAttribute("messageError", message.substring(4));
		} else if (message.startsWith("[S]:")) {
			model.addAttribute("messageSuccess", message.substring(4));
		}
		model.addAttribute(ATTR_PAGE, PAGE_ETUDIANTS);
		model.addAttribute(ATTR_ETUDIANTS, etudiants);
		model.addAttribute(ATTR_ETUDIANT, etudiant);
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
		Etudiant etudiant = etudiantBusiness.findOneById(id);
		model.addAttribute(ATTR_PAGE, PAGE_ETUDIANT);
		model.addAttribute(ATTR_ETUDIANT, etudiant);
		return "etudiant/update";
	}

}
