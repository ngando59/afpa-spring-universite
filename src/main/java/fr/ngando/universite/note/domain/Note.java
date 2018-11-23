package fr.ngando.universite.note.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.ngando.universite.etudiant.domain.Etudiant;
import fr.ngando.universite.matiere.domain.Matiere;
import lombok.Data;

@Entity
@Table(name = "tbl_note")
@Data
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotePK id;

	@ManyToOne
	@JoinColumn(name = "id_matiere", insertable = false, updatable = false)
	private Matiere matiere;

	@ManyToOne
	@JoinColumn(name = "id_etudiant", insertable = false, updatable = false)
	private Etudiant etudiant;

	@Column(name = "note")
	private Double value;

}
