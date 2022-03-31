package control;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.EscolaridadeDao;
import model.negocio.Escolaridade;

/**
 * 
 * @author Alexandre Jorge
 *
 */

@ManagedBean
@RequestScoped
@SuppressWarnings("static-method")
public class ControleEscolaridade {

    private Escolaridade selecionado;
    private EscolaridadeDao dao;

    public ControleEscolaridade() {
    	selecionado = new Escolaridade();
    	dao = new EscolaridadeDao();
    }

    public ArrayList<Escolaridade> listar() {
        try {
            return (ArrayList<Escolaridade>) dao.recuperarTodos();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Escolaridades.", ""));
            return new ArrayList<Escolaridade>();
        }
    }

    public Escolaridade getSelecionado() {
    	return selecionado;
    }

    public void setSelecionado(Escolaridade selecionado) {
    	this.selecionado = selecionado;
    }
    
}