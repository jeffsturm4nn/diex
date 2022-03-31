package model.DAO;

import java.util.List;
import model.negocio.Escolaridade;

/**
 *
 * @author Administrador-Pc
 */
public class EscolaridadeDao extends GenericDao<Escolaridade> implements Repositorio<Escolaridade> {
    
    
    public EscolaridadeDao() {
        super();
    }
    
    @Deprecated
    @Override
    public int adicionar(Escolaridade objeto) {
    	
        return -1;
        
    }

    @Deprecated
    @Override
    public boolean alterar(Escolaridade objeto) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public boolean remover(int codigo) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public Escolaridade recuperarPorId(int codigo) {
    	
        return null;
        
    }

    @Override
    public List<Escolaridade> recuperarTodos()  throws Exception{
    	
        return retrieveAll();
        
    }
    
}
