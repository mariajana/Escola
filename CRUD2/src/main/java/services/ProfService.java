package services;

import java.hugo.daw.crud.Professor;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.ProfessorDAO;
import util.TransacionalCdi;

@ApplicationScoped
public class ProfService implements Serializable, Service<Professor> {

	private static final long serialVersionUID = -7803325791425670859L;

	@Inject
	private ProfessorDAO profDAO;

	@Override
	@TransacionalCdi
	public void save(Professor prof) {
		prof.setPassword(hash(prof.getPassword()));
		profDAO.save(prof);
	}

	private String hash (String password) {
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
	public void update(Professor prof) {
		profDAO.update(prof);
	}

	@Override
	@TransacionalCdi
	public void remove(Professor prof) {
		profDAO.remove(prof);
	}

	@Override
	public Professor getByID(long profId) {
		return profDAO.getByID(profId);
	}

	@Override
	public List<Professor> getAll() {
		return profDAO.getAll();
	}

}
