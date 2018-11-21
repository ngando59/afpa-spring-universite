package fr.ngando.universite.enseignant.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ngando.universite.enseignant.business.IEnseignantBusiness;
import fr.ngando.universite.enseignant.domain.Enseignant;
import fr.ngando.universite.enseignant.repository.IEnseignantRepository;

@Service
public class EnseignantBusinessImpl implements IEnseignantBusiness {

	private static Logger LOGGER = LoggerFactory.getLogger(EnseignantBusinessImpl.class);

	@Autowired
	private IEnseignantRepository enseignantRepository;

	@Override
	public void delete(Enseignant enseignant) {
		enseignantRepository.delete(enseignant);
	}

	@Override
	public List<Enseignant> findAll() {
		return enseignantRepository.findAll();
	}

	@Override
	public Enseignant findOneById(Integer id) {
		return enseignantRepository.getOne(id);
	}

	@Override
	public String insert(Enseignant enseignant) {
		List<Enseignant> enseignants = enseignantRepository.findAll();
		boolean exists = false;
		String message = "";
		for (Enseignant e : enseignants) {
			if (e.getNumeroEnseignant().intValue() == enseignant.getNumeroEnseignant().intValue()) {
				exists = true;
				message = "[E]:Ce numéro d'enseignant est déjà enregistré !";
				LOGGER.info("tentative enregistrement numéro enseignant existant!");
			}
		}
		if (!exists) {
			enseignantRepository.save(enseignant);
		}
		return message;
	}

	@Override
	public void update(Enseignant enseignant) {
		Enseignant e = enseignantRepository.getOne(enseignant.getId());
		e.setNom(enseignant.getNom());
		e.setPrenom(enseignant.getPrenom());
		e.setSexe(enseignant.getSexe());
		e.setGrade(enseignant.getGrade());
		enseignantRepository.save(e);
	}

}
