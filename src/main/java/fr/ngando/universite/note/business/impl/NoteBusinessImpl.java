package fr.ngando.universite.note.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ngando.universite.etudiant.domain.Etudiant;
import fr.ngando.universite.matiere.domain.Matiere;
import fr.ngando.universite.note.business.INoteBusiness;
import fr.ngando.universite.note.domain.Note;
import fr.ngando.universite.note.domain.NotePK;
import fr.ngando.universite.note.repository.INoteRepository;

@Service
public class NoteBusinessImpl implements INoteBusiness {

	@Autowired
	private INoteRepository noteRepository;

	@Override
	public Note findNote(Etudiant etudiant, Matiere matiere) {
		return noteRepository.getOne(new NotePK(etudiant.getId(), matiere.getId()));
	}

	@Override
	public List<Note> findNoteByMatiere(Matiere matiere) {
		return matiere.getNotes();
	}

}
