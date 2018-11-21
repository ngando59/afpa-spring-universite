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

@Entity
@Table(name = "tbl_note")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotePK id;

	@ManyToOne
	@JoinColumn(name = "id_matiere", insertable = false, updatable = false)
	private transient Matiere matiere;

	@ManyToOne
	@JoinColumn(name = "id_etudiant", insertable = false, updatable = false)
	private transient Etudiant etudiant;

	@Column(name = "note")
	private Double note;

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public NotePK getId() {
		return id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public Double getNote() {
		return note;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public void setId(NotePK id) {
		this.id = id;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public void setNote(Double note) {
		this.note = note;
	}

}
