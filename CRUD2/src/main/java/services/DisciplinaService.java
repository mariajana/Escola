package services;

import java.hugo.daw.crud.Disciplina;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.DisciplinaDAO;
import util.TransacionalCdi;

@ApplicationScoped
public class DisciplinaService implements Serializable, Service<Disciplina> {

	private static final long serialVersionUID = -7803325791425670859L;

	@Inject
	private DisciplinaDAO disciplinaDAO;

	@Override
	@TransacionalCdi
	public void save(Disciplina disciplina) {
		disciplina.setPassword(hash(disciplina.getPassword()));
		disciplinaDAO.save(disciplina);
	}

	@Override
	@TransacionalCdi
	public void update(Disciplina disciplina) {
		disciplinaDAO.update(disciplina);
	}

	@Override
	@TransacionalCdi
	public void remove(Disciplina disciplina) {
		disciplinaDAO.remove(disciplina);
	}

	@Override
	public Disciplina getByID(long disciplinaId) {
		return disciplinaDAO.getByID(disciplinaId);
	}

	@Override
	public List<Disciplina> getAll() {
		return disciplinaDAO.getAll();
	}
}
