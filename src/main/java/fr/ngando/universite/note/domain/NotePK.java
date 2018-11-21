package fr.ngando.universite.note.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NotePK implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "id_etudiant")
	private Integer etudiant;
	@Column(name = "id_matiere")
	private Integer matiere;

	public NotePK() {
		super();
	}

	public NotePK(Integer etudiant, Integer matiere) {
		super();
		this.etudiant = etudiant;
		this.matiere = matiere;
	}

	public Integer getEtudiant() {
		return etudiant;
	}

	public Integer getMatiere() {
		return matiere;
	}

	public void setEtudiant(Integer etudiant) {
		this.etudiant = etudiant;
	}

	public void setMatiere(Integer matiere) {
		this.matiere = matiere;
	}
}
