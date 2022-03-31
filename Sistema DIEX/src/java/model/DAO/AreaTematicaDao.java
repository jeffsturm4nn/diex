/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.AreaTematica;

/**
 *
 * @author Fabricio Paes
 */
public class AreaTematicaDao extends GenericDao<AreaTematica> implements Repositorio<AreaTematica> {
    
    public AreaTematicaDao() {
        super();
    }
    
    @Override
    @Deprecated
    public int adicionar(AreaTematica objeto) {
    	
        return -1;
        
    }
    
    @Override
    @Deprecated
    public boolean alterar(AreaTematica objeto) {
    	
        return false;
        
    }
  
    @Override
    @Deprecated
    public boolean remover(int codigo) {
        return false;

    }
    
    @Override
    @Deprecated
    public AreaTematica recuperarPorId(int codigo) {
    	
    	return null;
    	
    }
    
	@Override
    public List<AreaTematica> recuperarTodos() throws Exception{
    	
    	return retrieveAll();
    	
    }
    
}
