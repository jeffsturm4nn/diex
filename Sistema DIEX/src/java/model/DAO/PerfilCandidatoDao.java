package model.DAO;

import java.util.List;
import model.negocio.PerfilCandidato;

/**
 *
 * @author Administrador-Pc
 */
public class PerfilCandidatoDao extends GenericDao<PerfilCandidato> implements Repositorio<PerfilCandidato> {
    
    public PerfilCandidatoDao() {
        super();
    }
    
    @Deprecated
    @Override
    public int adicionar(PerfilCandidato objeto) {
    	
        return -1;
        
    }

    @Deprecated
    @Override
    public boolean alterar(PerfilCandidato objeto) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public boolean remover(int codigo) {
    	
        return false;
        
    }

    @Deprecated
    @Override
    public PerfilCandidato recuperarPorId(int codigo) {
    	
        return null;
        
    }

    @Override
    public List<PerfilCandidato> recuperarTodos()  throws Exception {
    	
        return retrieveAll();
        
    }
}
