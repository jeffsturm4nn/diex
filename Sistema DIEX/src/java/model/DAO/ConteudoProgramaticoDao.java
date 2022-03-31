/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.ConteudoProgramatico;

/**
 *
 * @author Administrador-Pc
 */
public class ConteudoProgramaticoDao extends GenericDao<ConteudoProgramatico> implements Repositorio<ConteudoProgramatico> {
    
    public ConteudoProgramaticoDao() {
        super();
    } 
    
    @Override
    
    public int adicionar(ConteudoProgramatico conteudo)  throws Exception{
    	
        return save(conteudo);
        
    }
    
    @Override
    public boolean alterar(ConteudoProgramatico conteudo)  throws Exception{
    	
        return update(conteudo);
        
    }
  
    @Override
    public boolean remover(int codigo) throws Exception {

    	ConteudoProgramatico con = retrieveById(codigo);
    	
    	delete(con);
    	return true;

    }
    
    @Override
    @Deprecated
    public ConteudoProgramatico recuperarPorId(int codigo) {
    	
    	return null;
    	
    }
    
    @Override
    public List<ConteudoProgramatico> recuperarTodos()  throws Exception{
    	
    	return retrieveAll();
    	
    }
}
