package model.DAO;

import java.util.List;
import model.negocio.Estado;

/**
 *
 * @author Administrador-Pc
 */
public class EstadoDao extends GenericDao<Estado> implements Repositorio<Estado>{
    
    
    public EstadoDao() {
        super();
    }
    
    @Deprecated
    @Override
    public int adicionar(Estado objeto) {
    	
        return -1;
        
    }

    @Deprecated
    @Override
    public boolean alterar(Estado objeto) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public boolean remover(int codigo) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public Estado recuperarPorId(int codigo) {
    	
        return null;
        
    }

    @Override
    public List<Estado> recuperarTodos()  throws Exception{
    	
        return retrieveAll();
        
    }
    
}
