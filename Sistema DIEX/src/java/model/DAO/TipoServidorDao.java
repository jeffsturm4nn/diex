package model.DAO;

import java.util.List;
import model.negocio.TipoServidor;

/**
 *
 * @author Administrador-Pc
 */
public class TipoServidorDao extends GenericDao<TipoServidor> implements Repositorio<TipoServidor> {
    
    public TipoServidorDao() {
        super();
    }
    
    @Deprecated
    @Override
    public int adicionar(TipoServidor objeto) {
    	
        return -1;
        
    }

    @Deprecated
    @Override
    public boolean alterar(TipoServidor objeto) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public boolean remover(int codigo) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public TipoServidor recuperarPorId(int codigo) {
    	
        return null;
        
    }

    @Override
    public List<TipoServidor> recuperarTodos() throws Exception {
    	
        return retrieveAll();
        
    }
    
}
