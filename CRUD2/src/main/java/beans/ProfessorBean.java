package beans;

import java.hugo.daw.crud.Professor;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import services.ProfService;

@ViewScoped
@Named
public class ProfessorBean implements Serializable {

	@Inject
	private ProfService service;

	protected Professor professor;

	protected Collection<Professor> professores;

	public ProfessorBean() {
	}

	@PostConstruct
	public void init() {
		professor = newProfessor();
		professores = getService().getAll();
	}

	public void remove(Professor professor) {
		getService().remove(professor);
		limpar();
	}

	public Professor getEntidade() {
		return professor;
	}

	public void setEntidade(Professor entidade) {
		this.professor = entidade;
	}

	public Collection<Professor> getEntidades() {
		return professores;
	}

	public void setEntidades(Collection<Professor> professores) {
		this.professores = professores;
	}

	public void save() {
		getService().save(professor);
		limpar();
	}

	public void editar(Long id) {
		this.getProfessor().setId(id);
		save();
	}

	public void limpar() {
		professores = getService().getAll();
		professor = newProfessor();
	}

	protected Professor newProfessor() {
		return new Professor();
	}

	public ProfService getService() {
		return service;
	}

}
