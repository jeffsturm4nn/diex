package model.DAO;

import java.util.List;

public interface Repositorio<T> {

	public int adicionar(T objeto)  throws Exception;
	public boolean alterar(T objeto)  throws Exception;
	public boolean remover(int codigo)  throws Exception;
	public T recuperarPorId(int codigo)  throws Exception;
	public List<T> recuperarTodos()  throws Exception;

}
