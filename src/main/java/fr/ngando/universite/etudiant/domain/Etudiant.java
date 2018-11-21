package fr.ngando.universite.etudiant.domain;

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

@Entity
@Table(name = "tbl_etudiant")
public class Etudiant {
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

	public Etudiant() {
		super();
	}

	public String getAdresse() {
		return adresse;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public Integer getNumEtudiant() {
		return numEtudiant;
	}

	public String getPrenom() {
		return prenom;
	}

	public Character getSexe() {
		return sexe;
	}

	public Double getTotalNotes() {
		Double total = 0.0;
		for (Note n : this.notes) {
			total += n.getValue();
		}
		return total;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public void setNumEtudiant(Integer numEtudiant) {
		this.numEtudiant = numEtudiant;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}

}
