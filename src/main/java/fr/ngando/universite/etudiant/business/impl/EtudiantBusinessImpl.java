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
		return etudiantRepository.findAll();
	}

	@Override
	public List<Etudiant> findAllMen() {
		return etudiantRepository.findBySexe('M');
	}

	@Override
	public List<Note> findAllNoteMoreThan10(Etudiant etudiant) {
		return noteRepository.findByNoteGreaterThanEqualAndIdEtudiantIs(10.0, etudiant.getId());
	}

	@Override
	public List<Etudiant> findAllWomen() {
		return etudiantRepository.findBySexe('M');
	}

	@Override
	public Etudiant findOneById(Integer id) {
		return etudiantRepository.getOne(id);
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
			etudiantRepository.save(etudiant);
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
