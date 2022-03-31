package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.LocalRealizacaoDao;
import model.negocio.AreaTematica;
import model.negocio.LocalRealizacao;

/**
 * 
 * @author Alexandre Jorge
 *
 */

@ManagedBean
@RequestScoped
@SuppressWarnings("static-method")
public class ControleLocalRealizacao {
	
	private LocalRealizacao selecionado;
	private LocalRealizacaoDao dao;
	
	public ControleLocalRealizacao(){
		selecionado = new LocalRealizacao();
		dao = new LocalRealizacaoDao();
	}
	
	public ArrayList<LocalRealizacao> listar(){
            try {
                return (ArrayList<LocalRealizacao>) dao.recuperarTodos();
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Locais de Realizacao.", ""));
                return new ArrayList<LocalRealizacao>();
            }
	}

}
