package fr.ngando.universite.accueil.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ngando.universite.accueil.controller.IAccueilController;

@Controller
public class AcceuilControllerImpl implements IAccueilController {

	@Override
	@RequestMapping("")
	public String accueil(Model model) {
		String page = "Accueil";
		model.addAttribute("page", page);
		return "accueil/index";
	}

}
