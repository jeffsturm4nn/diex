package model.DAO;

import java.util.List;

import model.negocio.Servidor;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fabricio
 */
public class ServidorDao extends GenericDao<Servidor> implements Repositorio<Servidor> {
    
	public ServidorDao() {
		
		super();
	
	}
	
	@Override
    public int adicionar(Servidor servidor) throws Exception {
    	
        return save(servidor);
        
    }
    
	@Override
    public boolean alterar(Servidor servidor)  throws Exception{
    	
        return update(servidor);
        
    }
    
	@Override
    public boolean remover(int codigo)  throws Exception{

    	Servidor servidor = retrieveById(codigo);
    	servidor.setAtivo(0);
    	
    	return update(servidor);

    }
    
	@Override
    public Servidor recuperarPorId(int codigo) throws Exception {
    	
    	return retrieveById(codigo);
    	
    }
        
    
	@Override
    public List<Servidor> recuperarTodos()  throws Exception{
    	
    	return retrieveAll();
    	
    }
    	
}
