package fr.ngando.universite.enseignant.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ngando.universite.enseignant.business.IEnseignantBusiness;
import fr.ngando.universite.enseignant.domain.Enseignant;
import fr.ngando.universite.enseignant.repository.IEnseignantRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EnseignantBusinessImpl implements IEnseignantBusiness {

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
				log.info("tentative enregistrement numéro enseignant existant!");
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
