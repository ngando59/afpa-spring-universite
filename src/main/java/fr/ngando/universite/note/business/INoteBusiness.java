package fr.ngando.universite.note.business;

import java.util.List;

import fr.ngando.universite.etudiant.domain.Etudiant;
import fr.ngando.universite.matiere.domain.Matiere;
import fr.ngando.universite.note.domain.Note;

public interface INoteBusiness {
	public Note findNote(Etudiant etudiant, Matiere matiere);

	public List<Note> findNoteByMatiere(Matiere matiere);
}
