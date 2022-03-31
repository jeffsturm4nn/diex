/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.Endereco;

/**
 *
 * @author JeffSturmann
 */

public class EnderecoDao extends GenericDao<Endereco> implements Repositorio<Endereco>{

    @Override
    public int adicionar(Endereco objeto)  throws Exception{
        return save((Endereco)objeto);
    }

    @Override
    public boolean alterar(Endereco objeto) throws Exception {
        return update((Endereco)objeto);
    }

    @Deprecated
    @Override
    public boolean remover(int codigo) {
        return false;
    }

    @Override
    public Endereco recuperarPorId(int codigo)  throws Exception{
        return retrieveById(codigo);
    }

    @Override
    public List recuperarTodos()  throws Exception{
        return retrieveAll();
    }
}
