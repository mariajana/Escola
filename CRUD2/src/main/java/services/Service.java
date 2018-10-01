package services;

import java.hugo.daw.crud.Identificavel;
import java.util.List;

public interface Service<E extends Identificavel> {

	void save(E e);

	void update(E e);

	void remove(E e);

	E getByID(long userId);

	List<E> getAll();

}