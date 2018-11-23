package fr.ngando.universite.note.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class NotePK implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "id_etudiant")
	private Integer etudiant;
	@Column(name = "id_matiere")
	private Integer matiere;

	public NotePK(Integer etudiant, Integer matiere) {
		super();
		this.etudiant = etudiant;
		this.matiere = matiere;
	}

}
