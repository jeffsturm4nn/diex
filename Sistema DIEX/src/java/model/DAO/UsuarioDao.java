package model.DAO;

import java.util.List;

import model.negocio.Usuario;

/**
 *
 * @author Fabricio
 */
public class UsuarioDao extends GenericDao<Usuario> implements Repositorio<Usuario> {
    
	public UsuarioDao() {
		
		super();
		
	}

	@Override
	public int adicionar(Usuario usuario)  throws Exception{

		return save(usuario);
		
	}

	@Override
	public boolean alterar(Usuario usuario)  throws Exception{

		return update(usuario);
		
	}

	@Override
	public boolean remover(int codigo)  throws Exception{
                
		Usuario usuario = retrieveById(codigo);
                usuario.setAtivo(0);
               return update(usuario);
               
		
	}

	@Deprecated
	@Override
	public Usuario recuperarPorId(int codigo) {
		
		return null;
		
	}
	
	@Deprecated
	@Override
	public List<Usuario> recuperarTodos() {
		
		return null;
		
	}
    
}
