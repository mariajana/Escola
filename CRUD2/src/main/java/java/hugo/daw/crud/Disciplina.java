package java.hugo.daw.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Disciplina implements Identificavel{
	
	@Id
	@GeneratedValue(generator = "disciplina_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "disciplina_seq")
	private Long id;
	private String nome;
	private String professor;
	
	
	public Disciplina() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getProfessor() {
		return professor;
	}
	
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	public Disciplina(Long id, String nome, String professor) {
		super();
		this.id = id;
		this.nome = nome;
		this.professor = professor;
	}
	
	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", professor=" + professor + "]";
	}
	
}
