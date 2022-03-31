package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.CoordenacaoDao;
import model.negocio.Coordenacao;

/**
 * 
 * @author Alexandre Jorge
 *
 */

@ManagedBean
@RequestScoped
@SuppressWarnings("static-method")
public class ControleCoordenacao {
	
	private Coordenacao selecionado;
	private CoordenacaoDao dao;
	
	public ControleCoordenacao(){
		super();
		this.selecionado = new Coordenacao();
		this.dao = new CoordenacaoDao();
	}
	
	public ArrayList<Coordenacao> listar(){
            try {
                return (ArrayList<Coordenacao>) dao.recuperarTodos();
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Coordenacoes.", ""));
                return new ArrayList<Coordenacao>();
            }
	}
	
	public Coordenacao getSelecionado(){
		return selecionado;
	}
	
	public void setSelecionado(Coordenacao selecionado){
		this.selecionado = selecionado;
	}

}
