package fr.ngando.universite.matiere.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import fr.ngando.universite.enseignant.domain.Enseignant;
import fr.ngando.universite.note.domain.Note;

@Entity
@Table(name = "tbl_matiere")
public class Matiere implements Serializable {

	private static final long serialVersionUID = -5603795345652331297L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero_matiere")
	private Integer numeroMatiere;
	@Column(name = "nom")
	private String nom;
	@Column(name = "coef")
	private Integer coef;
	@Column(name = "date_debut")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDebut;
	@Column(name = "date_fin")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFin;
	@ManyToOne
	@JoinColumn(name = "id_enseignant")
	private Enseignant enseignant;
	@OneToMany(mappedBy = "matiere")
	@OrderBy("note DESC")
	private List<Note> notes;

	public Integer getCoef() {
		return coef;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public Enseignant getEnseignant() {
		return enseignant;
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

	public Integer getNumeroMatiere() {
		return numeroMatiere;
	}

	public void setCoef(Integer coef) {
		this.coef = coef;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
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

	public void setNumeroMatiere(Integer numeroMatiere) {
		this.numeroMatiere = numeroMatiere;
	}

}
