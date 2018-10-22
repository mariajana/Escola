package beans;

import java.hugo.daw.crud.Professor;
import java.hugo.daw.crud.Turma;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;

import services.TurmaService;

@ViewScoped
@Named
public class TurmaBean implements Serializable {
	
	@Inject
	private TurmaService service;

	protected Turma turma;

	protected Collection<Turma> turmas;

	public TurmaBean() {
	}

	@PostConstruct
	public void init() {
		turma = newTurma();
		turmas = getService().getAll();
	}

	public void remove(Turma turma) {
		getService().remove(turma);
		limpar();
	}

	public Turma getEntidade() {
		return turma;
	}

	public void setEntidade(Turma turma) {
		this.turma = turma;
	}

	public Collection<Turma> getEntidades() {
		return turmas;
	}

	public void setEntidades(Collection<Turma> turmas) {
		this.turmas = turmas;
	}

	public void save() {
		getService().save(turma);
		limpar();
	}

	public void editar(Long id) {
		this.getTurma().setId(id);
		save();
	}

	public void limpar() {
		turmas = getService().getAll();
		turma = newTurma();
	}

	protected Turma newProfessor() {
		return new Turma();
	}

	public TurmaService getService() {
		return service;
	}

}


}
