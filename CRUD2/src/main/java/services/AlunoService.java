package services;

package services;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.AlunoDAO;

@ApplicationScoped
public class AlunoService implements Serializable, Service<Aluno> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7803325791425670859L;

	@Inject
	private AlunoDAO userDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.ifpb.esperanca.daw2.services.Service#save(br.edu.ifpb.esperanca.daw2.
	 * ifoto.entities.Usuario)
	 */
	@Override
	@TransacionalCdi
	public void save(Professor aluno) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.ifpb.esperanca.daw2.services.Service#update(br.edu.ifpb.esperanca.daw2
	 * .ifoto.entities.Usuario, boolean)
	 */
	@Override
	@TransacionalCdi
	public void update(Aluno aluno) {
		alunoDAO.update(aluno);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.ifpb.esperanca.daw2.services.Service#delete(br.edu.ifpb.esperanca.daw2
	 * .ifoto.entities.Usuario)
	 */
	@Override
	@TransacionalCdi
	public void remove(Aluno aluno) {
		alunoDAO.remove(aluno);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getByID(long)
	 */
	@Override
	public Aluno getByID(long alunoId) {
		return alunoDAO.getByID(alunoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getAll()
	 */
	@Override
	public List<Aluno> getAll() {
		return alunoDAO.getAll();
	}

}
