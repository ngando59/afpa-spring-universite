package fr.ngando.universite.note.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ngando.universite.note.domain.Note;
import fr.ngando.universite.note.domain.NotePK;

public interface INoteRepository extends JpaRepository<Note, NotePK> {
	List<Note> findByValueGreaterThanEqualAndIdEtudiantIs(Double limit, Integer id);
}
