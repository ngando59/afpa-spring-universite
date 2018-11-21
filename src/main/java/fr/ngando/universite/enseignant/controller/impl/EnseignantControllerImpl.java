package fr.ngando.universite.enseignant.controller.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ngando.universite.enseignant.business.IEnseignantBusiness;
import fr.ngando.universite.enseignant.controller.IEnseignantController;
import fr.ngando.universite.enseignant.domain.Enseignant;

@Controller
public class EnseignantControllerImpl implements IEnseignantController {

	public final static String PAGE_ENSEIGNANT = "Enseignant";
	public final static String PAGE_ENSEIGNANTS = "Enseignants";
	public final static String PAGE = "page";
	public final static String ENSEIGNANT = "enseignant";
	public final static String ENSEIGNANTS = "enseignants";

	@Autowired
	private IEnseignantBusiness enseignantBusiness;

	@Override
	@RequestMapping("/delete-enseignant")
	public String deleteEnseignant(Model model, @RequestParam Integer id) {
		Enseignant enseignant = enseignantBusiness.findOneById(id);
		enseignantBusiness.delete(enseignant);
		return "redirect:/enseignants";
	}

	@Override
	@RequestMapping("/enseignant")
	public String enseignant(Model model, @RequestParam Integer id) {
		Enseignant enseignant = enseignantBusiness.findOneById(id);
		model.addAttribute(PAGE, PAGE_ENSEIGNANT);
		model.addAttribute(ENSEIGNANT, enseignant);
		return "enseignant/enseignant";
	}

	@Override
	@RequestMapping("/enseignants")
	public String enseignants(Model model) {
		List<Enseignant> enseignants = enseignantBusiness.findAll();
		model.addAttribute(PAGE, PAGE_ENSEIGNANTS);
		model.addAttribute(ENSEIGNANTS, enseignants);
		return "enseignant/enseignants";
	}

	@Override
	@RequestMapping("/new-enseignant")
	public String formAddEnseignant(Model model) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1933);
		cal.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal.set(Calendar.DAY_OF_MONTH, 14);
		Date dateNaissance = cal.getTime();
		cal.set(Calendar.YEAR, 1982);
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dateEmbauche = cal.getTime();

		model.addAttribute(ENSEIGNANT,
				new Enseignant(null, 10008, "Biya", "Popaul", dateNaissance, 'M', "ASS", dateEmbauche));
		model.addAttribute(PAGE, PAGE_ENSEIGNANTS);
		return "enseignant/add-form";
	}

	@Override
	@RequestMapping("/update-enseignant")
	public String formUpdateEnseignant(Model model, @RequestParam Integer id) {
		Enseignant enseignant = enseignantBusiness.findOneById(id);
		model.addAttribute(PAGE, PAGE_ENSEIGNANT);
		model.addAttribute(ENSEIGNANT, enseignant);
		return "enseignant/update-form";
	}

	@Override
	@PostMapping("/insertEnseignant")
	public String insertEnseignant(Model model, @ModelAttribute Enseignant enseignant) {
		String message = enseignantBusiness.insert(enseignant);
		model.addAttribute(PAGE, PAGE_ENSEIGNANT);
		if (message.startsWith("[E]:")) {
			model.addAttribute("messageError", message.substring(4));
			return "enseignant/add-form";
		} else if (message.startsWith("[S]:")) {
			model.addAttribute("messageSuccess", message.substring(4));
			List<Enseignant> enseignants = enseignantBusiness.findAll();
			model.addAttribute(ENSEIGNANTS, enseignants);
			return "enseignant/enseignants";
		}
		return null;
	}

	@Override
	@PostMapping("/updateEnseignant")
	public String updateEnseignant(Model model, @ModelAttribute Enseignant enseignant) {
		enseignantBusiness.update(enseignant);
		return "redirect:/update-enseignant?id=" + enseignant.getId();
	}

}
