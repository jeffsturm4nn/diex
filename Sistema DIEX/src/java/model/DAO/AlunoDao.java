package model.DAO;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import model.negocio.Aluno;
import model.negocio.Endereco;
import model.negocio.Escolaridade;
import model.negocio.Estado;
import model.negocio.PerfilCandidato;

/**
 *
 * @author Fabricio
 */
public class AlunoDao extends GenericDao<Aluno> implements Repositorio<Aluno> {
    
	public AlunoDao() {
		
		super();
	
	}
	
	@Override
    public int adicionar(Aluno aluno) throws Exception{
    	
        return save(aluno);
        
    }
    
	@Override
    public boolean alterar(Aluno aluno) throws Exception{
    	
        return update(aluno);
        
    }
    
	@Override
    public boolean remover(int codigo) throws Exception{

		Aluno aluno = retrieveById(codigo);
    	aluno.setAtivo(0);
    	
    	return update(aluno);

    }
    
	@Override
    public Aluno recuperarPorId(int codigo) throws Exception{
    	
    	return retrieveById(codigo);
    	
    }
    
	@Override
    public List<Aluno> recuperarTodos() throws Exception{
    	
    	return retrieveAll();
    	
    }
	
	public Aluno recuperarPorCpf(String cpf) {
		
		return (Aluno) createSession().createCriteria(Aluno.class)	
				.add(Restrictions.eq("numCpf", cpf)).uniqueResult();
		
	}
    
}
