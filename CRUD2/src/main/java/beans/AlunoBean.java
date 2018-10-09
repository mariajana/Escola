package beans;

import java.hugo.daw.crud.Aluno;
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
public class AlunoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Aluno aluno = new Aluno();
	private Collection<Aluno> alunos;

	@Inject
	private AlunoService service;

	protected Aluno aluno;

	protected Collection<Aluno> alunos;

	public AlunoBean() {
	}

	@PostConstruct
	public void init() {
		aluno = newAluno();
		alunos = getService().getAll();
	}
	
	public void onRowEdit(Aluno obj) {
		service.update(obj);
		FacesMessage msg = new FacesMessage("Aluno editado", obj.getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		limpar();
	}

	public void removerAluno(Aluno aluno) {
		service().remove(aluno);
		limpar();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Collection<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Collection<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void save() {
		service().save(aluno);
		limpar();
	}

	public void editar(Long id) {
		this.getAluno().setId(id);
		save();
	}

	public void limpar() {
		alunos = getService().getAll();
		aluno = newAluno();
	}

	public AlunoService getService() {
		return service;
	}
	
	public void setService(AlunoService service) {
		this.service = service;
	}

}
