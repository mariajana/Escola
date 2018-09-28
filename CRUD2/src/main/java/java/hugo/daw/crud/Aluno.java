package java.hugo.daw.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Aluno implements Identificavel{

	@Id
	@GeneratedValue(generator = "aluno_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "aluno_seq")
	private Long id;
	private String nome;
	private String dataDeNascimento;

	public Aluno() {
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

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Aluno(Long id, String nome, String dataDeNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + "]";
	}

}
