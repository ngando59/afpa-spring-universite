package fr.ngando.universite.matiere.business;

import java.util.List;

import fr.ngando.universite.enseignant.domain.Enseignant;
import fr.ngando.universite.matiere.domain.Matiere;
import fr.ngando.universite.note.domain.Note;

public interface IMatiereBusiness {
	public List<Matiere> findAll();

	public List<Enseignant> findAllEnseigant();

	public List<Note> findAllNotesByMatiere(Matiere matiere);

	public Matiere findOneById(Integer id);

	public void update(Matiere matiere);
}
