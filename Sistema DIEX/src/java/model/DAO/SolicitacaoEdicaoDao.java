/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.negocio.SolicitacaoEdicao;

/**
 *
 * @author Administrador-Pc
 */
public class SolicitacaoEdicaoDao extends GenericDao<SolicitacaoEdicao> implements Repositorio<SolicitacaoEdicao>{
 
    public SolicitacaoEdicaoDao() {
        super();
    }

    @Override
    public int adicionar(SolicitacaoEdicao solicitacao) throws Exception {
        
        return save(solicitacao);
        
    }

    @Override
    @Deprecated
    public boolean alterar(SolicitacaoEdicao solicitacao) throws Exception {
        return false;
    }

    @Override
    @Deprecated
    public boolean remover(int codigo) throws Exception {
        
        return false;
        
    }

    @Override
    @Deprecated
    public SolicitacaoEdicao recuperarPorId(int codigo) throws Exception {
        
        return null;
        
    }

    @Override
    public List<SolicitacaoEdicao> recuperarTodos() throws Exception {
       
        return retrieveAll();
        
    }
}
