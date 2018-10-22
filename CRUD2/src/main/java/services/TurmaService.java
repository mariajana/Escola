package services;

public class TurmaService {
	
	@ApplicationScoped
	public class TurmaService implements Serializable, Service<Usuario> {

	/**
	* 
	*/
	private static final long serialVersionUID = -7803325791425670859L;
		
	@Inject
	private TurmaDAO turmaDAO;
		
	/* (non-Javadoc)
	* @see br.edu.ifpb.esperanca.daw2.services.Service#save(br.edu.ifpb.esperanca.daw2.ifoto.entities.Usuario)
	*/
	@Override
	@TransacionalCdi
	public void save(Turma turma) {
		turmaDAO.save(turma);
	}

	/* (non-Javadoc)
	* @see br.edu.ifpb.esperanca.daw2.services.Service#update(br.edu.ifpb.esperanca.daw2.ifoto.entities.Usuario, boolean)
	 */
	@Override
	@TransacionalCdi
	public void update(Turma turma)  {
			turmaDAO.update(turma);
	}

	/* (non-Javadoc)
	* @see br.edu.ifpb.esperanca.daw2.services.Service#delete(br.edu.ifpb.esperanca.daw2.ifoto.entities.Usuario)
	*/
	@Override
	@TransacionalCdi
	public void remove(Usuario user) {
		userDAO.remove(user);
	}

	/* (non-Javadoc)
	* @see br.edu.ifpb.esperanca.daw2.services.Service#getByID(long)
	*/
	@Override
	public Usuario getByID(long userId)  {
			return userDAO.getByID(userId);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getAll()
	 */
	@Override
	public List<Usuario> getAll() {
			return userDAO.getAll();
	}
			
}

}
