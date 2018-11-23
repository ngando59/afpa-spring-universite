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
import lombok.Data;

@Data
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

}
