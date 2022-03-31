/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.Curso;
import model.negocio.Servidor;

/**
 *
 * @author Administrador-Pc
 */
public class CursoDao extends GenericDao<Curso> implements Repositorio<Curso> {
    
    public CursoDao() {
        super();
    }
    
    @Override
    public int adicionar(Curso curso)  throws Exception{
    	
        return save(curso);
        
    }
    
    @Override
    public boolean alterar(Curso curso)  throws Exception{
    	
        return update(curso);
        
    }
    
    @Override
    public boolean remover(int codigo)  throws Exception{

    	Curso curso = retrieveById(codigo);
    	curso.setSituacao(0);
    	
    	return update(curso);

    }
    
    @Override
    public Curso recuperarPorId(int codigo)  throws Exception{
    	
    	return retrieveById(codigo);
    	
    }
    
    public Curso recuperarPorServidor(Servidor servidor) {
        return null;
    }
    
    @Override
    public List<Curso> recuperarTodos()  throws Exception{
    	
    	return retrieveAll();
    	
    }

    
}
