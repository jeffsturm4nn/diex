package model.DAO;

import java.util.List;
import model.negocio.Coordenacao;

/**
 *
 * @author Administrador-Pc
 */
public class CoordenacaoDao extends GenericDao<Coordenacao> implements Repositorio<Coordenacao> {
    
    
    public CoordenacaoDao() {
        super();
    }
    
    @Deprecated
    @Override
    public int adicionar(Coordenacao objeto) {
    	
        return -1;
        
    }

    @Deprecated
    @Override
    public boolean alterar(Coordenacao objeto) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public boolean remover(int codigo) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public Coordenacao recuperarPorId(int codigo) {
    	
        return null;
        
    }

    @Override
    public List<Coordenacao> recuperarTodos() throws Exception{
    	
        return retrieveAll();
        
    }
    
}
