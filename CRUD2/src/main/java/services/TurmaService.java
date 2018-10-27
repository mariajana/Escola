package services;

import java.hugo.daw.crud.Turma;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.TurmaDAO;
import util.TransacionalCdi;

public class TurmaService {
	
	@ApplicationScoped
	public class TurmaService implements Serializable, Service<Turma> {

	private static final long serialVersionUID = -7803325791425670859L;
		
	@Inject
	private TurmaDAO turmaDAO;
		
	@Override
	@TransacionalCdi
	public void save(Turma turma) {
		turmaDAO.save(turma);
	}

	@Override
	@TransacionalCdi
	public void update(Turma turma)  {
		turmaDAO.update(turma);
	}

	@Override
	@TransacionalCdi
	public void remove(Turma turma) {
		turmaDAO.remove(turma);
	}

	@Override
	public Turma getByID(long turmaId)  {
		return turmaDAO.getByID(turmaId);
	}

	@Override
	public List<Turma> getAll() {
		return turmaDAO.getAll();
	}
			
	}

}
