
package control;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.DAO.EstadoDao;
import model.negocio.Aluno;
import model.negocio.Estado;

/**
 *
 * @author Fabricio Paes, Jefferson Sales, Alexandre Jorge
 */

@ManagedBean
@ViewScoped
@SuppressWarnings("static-method")
public class ControleEstado {

    private Estado selecionado;
    private EstadoDao dao;

    public ControleEstado() {
    	selecionado = new Estado();
    	dao = new EstadoDao();
    }

    public ArrayList<Estado> listar() {
        try {
            return (ArrayList<Estado>) dao.recuperarTodos();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Estados.", ""));
            return new ArrayList<Estado>();
        }
    }

    public Estado getSelecionado() {
    	return selecionado;
    }

    public void setSelecionado(Estado selecionado) {
    	this.selecionado = selecionado;
    }
    
}
