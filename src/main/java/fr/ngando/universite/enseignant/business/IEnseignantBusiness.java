package fr.ngando.universite.enseignant.business;

import java.util.List;

import fr.ngando.universite.enseignant.domain.Enseignant;

public interface IEnseignantBusiness {

	public void delete(Enseignant enseignant);

	public List<Enseignant> findAll();

	public Enseignant findOneById(Integer id);

	public String insert(Enseignant enseignant);

	public void update(Enseignant enseignant);

}
