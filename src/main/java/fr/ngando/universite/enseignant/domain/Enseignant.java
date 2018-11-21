package fr.ngando.universite.enseignant.domain;

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

import fr.ngando.universite.matiere.domain.Matiere;

@Entity
@Table(name = "tbl_enseignant")
public class Enseignant implements Serializable {
	private static final long serialVersionUID = 6605028813495639388L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero_enseignant", unique = true)
	private Integer numeroEnseignant;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "date_naissance")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	@Column(name = "sexe")
	private Character sexe;
	@Column(name = "grade")
	private String grade;
	@Column(name = "date_embauche")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEmbauche;
	@OneToMany(mappedBy = "enseignant")
	private List<Matiere> matieres;

	public Enseignant() {
		super();
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public String getGrade() {
		return grade;
	}

	public Integer getId() {
		return id;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public String getNom() {
		return nom;
	}

	public Integer getNumeroEnseignant() {
		return numeroEnseignant;
	}

	public String getPrenom() {
		return prenom;
	}

	public Character getSexe() {
		return sexe;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNumeroEnseignant(int numeroEnseignant) {
		this.numeroEnseignant = numeroEnseignant;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

}
