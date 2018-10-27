package services;

import java.hugo.daw.crud.Aluno;
import java.hugo.daw.crud.Professor;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.AlunoDAO;
import util.TransacionalCdi;

@ApplicationScoped
public class AlunoService implements Serializable, Service<Aluno> {

	private static final long serialVersionUID = -7803325791425670859L;

	@Inject
	private AlunoDAO alunoDAO;

	@Override
	@TransacionalCdi
	public void save(Aluno aluno) {
		aluno.setPassword(hash(aluno.getPassword()));
		alunoDAO.save(aluno);
	}

	private String hash(String password) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			String output = Base64.getEncoder().encodeToString(digest);
			return output;
		} catch (Exception e) {
			return password;
		}
	}

	@Override
	@TransacionalCdi
	public void update(Aluno aluno) {
		alunoDAO.update(aluno);
	}

	@Override
	@TransacionalCdi
	public void remove(Aluno aluno) {
		alunoDAO.remove(aluno);
	}

	@Override
	public Aluno getByID(long alunoId) {
		return alunoDAO.getByID(alunoId);
	}

	@Override
	public List<Aluno> getAll() {
		return alunoDAO.getAll();
	}

}
