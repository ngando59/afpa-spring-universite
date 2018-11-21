package fr.ngando.universite.matiere.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ngando.universite.enseignant.business.IEnseignantBusiness;
import fr.ngando.universite.enseignant.domain.Enseignant;
import fr.ngando.universite.matiere.business.IMatiereBusiness;
import fr.ngando.universite.matiere.domain.Matiere;
import fr.ngando.universite.matiere.repository.IMatiereRepository;
import fr.ngando.universite.note.business.INoteBusiness;
import fr.ngando.universite.note.domain.Note;

@Service
public class MatiereBusinessImpl implements IMatiereBusiness {

	@Autowired
	private IMatiereRepository matiereRepository;
	@Autowired
	private IEnseignantBusiness enseignantBusiness;
	@Autowired
	private INoteBusiness noteBusiness;

	@Override
	public List<Matiere> findAll() {
		return matiereRepository.findAll();
	}

	@Override
	public List<Enseignant> findAllEnseigant() {
		return enseignantBusiness.findAll();
	}

	@Override
	public List<Note> findAllNotesByMatiere(Matiere matiere) {
		return noteBusiness.findNoteByMatiere(matiere);
	}

	@Override
	public Matiere findOneById(Integer id) {
		return matiereRepository.getOne(id);
	}

	@Override
	public void update(Matiere matiere) {
		Matiere m = matiereRepository.getOne(matiere.getId());
		m.setNom(matiere.getNom());
		m.setCoef(matiere.getCoef());
		m.setDateDebut(matiere.getDateDebut());
		m.setDateFin(matiere.getDateFin());
		m.setEnseignant(matiere.getEnseignant());
		matiereRepository.save(m);
	}

}
