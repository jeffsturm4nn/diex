/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.LocalRealizacao;

/**
 *
 * @author Administrador-Pc
 */
public class LocalRealizacaoDao extends GenericDao<LocalRealizacao> implements Repositorio<LocalRealizacao> {

    public LocalRealizacaoDao() {
        super();
    }
    
    @Override
    @Deprecated
    public int adicionar(LocalRealizacao objeto) {
    	
        return -1;
        
    }
    
    @Override
    @Deprecated
    public boolean alterar(LocalRealizacao objeto) {
    	
        return false;
        
    }
  
    @Override
    @Deprecated
    public boolean remover(int codigo) {
        return false;

    }
    
    @Override
    @Deprecated
    public LocalRealizacao recuperarPorId(int codigo) {
    	
    	return null;
    	
    }
    
    @Override
    public List<LocalRealizacao> recuperarTodos()  throws Exception{
    	
    	return retrieveAll();
    	
    }
}
