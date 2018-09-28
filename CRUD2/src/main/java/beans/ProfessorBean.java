package beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


public class ProfessorBean {

@ViewScoped
@Named
public class ProfessorBean implements Serializable {

	@Inject
	private ProfService service;

	protected Professor entidade;

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
		return entidade;
	}

	public void setEntidade(Usuario entidade) {
		this.entidade = entidade;
	}

	public Collection<Usuario> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Usuario> entidades) {
		this.entidades = entidades;
	}

	public void save() {
		getService().save(entidade);
		limpar();
	}

	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}

	public void limpar() {
		entidades = getService().getAll();
		entidade = newEntidade();
	}

	protected Usuario newEntidade() {
		return new Usuario();
	}

	public UserService getService() {
		return service;
	}

}

}
