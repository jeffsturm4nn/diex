/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.AreaConhecimento;

/**
 *
 * @author Administrador-Pc
 */
public class AreaConhecimentoDao extends GenericDao<AreaConhecimento> implements Repositorio<AreaConhecimento> {
    
    public AreaConhecimentoDao() {
        super();
    }
    
    @Override
    @Deprecated
    public int adicionar(AreaConhecimento objeto) {
    	
        return -1;
        
    }
    
    @Override
    @Deprecated
    public boolean alterar(AreaConhecimento objeto) {
    	
        return false;
        
    }
  
    @Override
    @Deprecated
    public boolean remover(int codigo) {
        return false;

    }
    
    @Override
    @Deprecated
    public AreaConhecimento recuperarPorId(int codigo) {
    	
    	return null;
    	
    }
    
	@Override
    public List<AreaConhecimento> recuperarTodos()throws Exception {
    	
    	return retrieveAll();
    	
    }

}
