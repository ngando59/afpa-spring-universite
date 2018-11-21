package fr.ngando.universite.etudiant.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ngando.universite.etudiant.business.IEtudiantBusiness;
import fr.ngando.universite.etudiant.domain.Etudiant;
import fr.ngando.universite.etudiant.repository.IEtudiantRepository;
import fr.ngando.universite.note.domain.Note;
import fr.ngando.universite.note.repository.INoteRepository;

@Service
public class EtudiantBusinessImpl implements IEtudiantBusiness {

	private static Logger LOGGER = LoggerFactory.getLogger(EtudiantBusinessImpl.class);

	@Autowired
	private IEtudiantRepository etudiantRepository;
	@Autowired
	private INoteRepository noteRepository;

	@Override
	public void delete(Etudiant etudiant) {
		etudiantRepository.delete(etudiant);
	}

	@Override
	public List<Etudiant> findAll() {
		List<Etudiant> etudiants = etudiantRepository.findAll();
		return etudiants;
	}

	@Override
	public List<Etudiant> findAllMen() {
		List<Etudiant> etudiants = etudiantRepository.findBySexe('M');
		return etudiants;
	}

	@Override
	public List<Note> findAllNoteMoreThan10(Etudiant etudiant) {
		List<Note> notes = noteRepository.findByNoteGreaterThanEqualAndIdEtudiantIs(10.0, etudiant.getId());
		return notes;
	}

	@Override
	public List<Etudiant> findAllWomen() {
		List<Etudiant> etudiants = etudiantRepository.findBySexe('M');
		return etudiants;
	}

	@Override
	public Etudiant findOneById(Integer id) {
		Etudiant etudiant = etudiantRepository.getOne(id);
		return etudiant;
	}

	@Override
	public String insert(Etudiant etudiant) {
		List<Etudiant> etudiants = etudiantRepository.findAll();
		boolean exists = false;
		String message = "";
		for (Etudiant e : etudiants) {
			if (e.getNumEtudiant().intValue() == etudiant.getNumEtudiant().intValue()) {
				exists = true;
				message = "[E]:Ce numéro d'etudiant est déjà enregistré !";
				LOGGER.info("tentative enregistrement numéro etudiant existant!");
			}
		}
		if (!exists) {
			Etudiant etudiant2 = null;
			etudiant2 = etudiantRepository.save(etudiant);
			if (etudiant2 != null) {
				message = "[S]:Nouvel etudiant enregistré !";
				LOGGER.info("nouvel etudiant enregistré !");
			} else {
				message = "[E]:Erreur lors de l'enregistrement !";
				LOGGER.info("echec enregistrement etudiant !");
			}
		}
		return message;
	}

	@Override
	public String update(Etudiant etudiant) {
		String message = "";
		Etudiant e = etudiantRepository.getOne(etudiant.getId());
		e.setNom(etudiant.getNom());
		e.setPrenom(etudiant.getPrenom());
		e.setSexe(etudiant.getSexe());
		e.setEmail(etudiant.getEmail());
		e.setAdresse(etudiant.getAdresse());
		etudiantRepository.save(e);
		message = "[S]:etudiant mis à jour !";
		return message;
	}
}
