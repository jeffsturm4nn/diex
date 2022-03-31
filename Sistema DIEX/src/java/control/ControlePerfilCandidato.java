package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.PerfilCandidatoDao;
import model.negocio.PerfilCandidato;

/**
 * 
 * @author Alexandre Jorge
 *
 */

@ManagedBean
@RequestScoped
@SuppressWarnings("static-method")

public class ControlePerfilCandidato {

	private PerfilCandidato selecionado;
	private PerfilCandidatoDao dao;
	
	public ControlePerfilCandidato() {
		super();
		this.selecionado = new PerfilCandidato();
		this.dao = new PerfilCandidatoDao();
	}
	
	public ArrayList<PerfilCandidato> listar(){
            try {
                return (ArrayList<PerfilCandidato>) dao.recuperarTodos();
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Perfis de Candidato.", ""));
                return new ArrayList<PerfilCandidato>();
            }
	}
	
	public PerfilCandidato getSelecionado(){
		return selecionado;
	}
	
	public void setSelecionado(PerfilCandidato selecionado){
		this.selecionado = selecionado;
	}
	
}
