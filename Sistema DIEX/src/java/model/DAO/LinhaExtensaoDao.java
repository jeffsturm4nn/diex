/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.LinhaExtensao;

/**
 *
 * @author Fabricio Paes
 */
public class LinhaExtensaoDao extends GenericDao<LinhaExtensao> implements Repositorio<LinhaExtensao> {
    
    public LinhaExtensaoDao() {
        super();
    }
    
    @Override
    @Deprecated
    public int adicionar(LinhaExtensao objeto) {
    	
        return -1;
        
    }
    
    @Override
    @Deprecated
    public boolean alterar(LinhaExtensao objeto) {
    	
        return false;
        
    }
  
    @Override
    @Deprecated
    public boolean remover(int codigo) {
        return false;

    }
    
    @Override
    @Deprecated
    public LinhaExtensao recuperarPorId(int codigo) {
    	
    	return null;
    	
    }
    
	@Override
    public List<LinhaExtensao> recuperarTodos()  throws Exception{
    	
    	return retrieveAll();
    	
    }
}
