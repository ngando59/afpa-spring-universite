package fr.ngando.universite.etudiant.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import fr.ngando.universite.note.domain.Note;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_etudiant")
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 7225934486117034285L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "num_etudiant", unique = true)
	private Integer numEtudiant;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "date_naissance")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	@Column(name = "sexe")
	private Character sexe;
	@Column(name = "email")
	private String email;
	@Column(name = "adresse")
	private String adresse;
	@OneToMany(mappedBy = "etudiant")
	private List<Note> notes;

	public Double getTotalNotes() {
		Double total = 0.0;
		for (Note n : this.notes) {
			total += n.getValue();
		}
		return total;
	}

}
