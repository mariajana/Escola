package java.hugo.daw.crud;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Turma implements Identificavel{

	@Id
	@GeneratedValue(generator = "turma_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "turma_seq")
	private Long id;
	private String professor;
	private String disciplina;
	
	@ManyToMany
	@JoinTable(name="turma_aluno", joinColumns=@JoinColumn(name="id_turma"), inverseJoinColumns=@JoinColumn(name="id_aluno"))
	private Set<Aluno> alunos;
	
	public Turma() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public Set<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
	public Turma(Long id, String professor, String disciplina) {
		super();
		this.id = id;
		this.professor = professor;
		this.disciplina = disciplina;
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", professor=" + professor + ", disciplina=" + disciplina + ", alunos = " + alunos +"]";
	}

}
