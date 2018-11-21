package fr.ngando.universite.etudiant.business;

import java.util.List;

import fr.ngando.universite.etudiant.domain.Etudiant;
import fr.ngando.universite.note.domain.Note;

public interface IEtudiantBusiness {
	public void delete(Etudiant etudiant);

	public List<Etudiant> findAll();

	public List<Etudiant> findAllMen();

	public List<Note> findAllNoteMoreThan10(Etudiant etudiant);

	public List<Etudiant> findAllWomen();

	public Etudiant findOneById(Integer id);

	public String insert(Etudiant etudiant);

	public String update(Etudiant etudiant);
}
