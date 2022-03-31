package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.LinhaExtensaoDao;
import model.negocio.AreaTematica;
import model.negocio.LinhaExtensao;

/**
 * 
 * @author Alexandre Jorge
 *
 */

@ManagedBean
@RequestScoped
@SuppressWarnings("static-method")
public class ControleLinhaExtensao {
	
	private LinhaExtensao selecionado;
	private LinhaExtensaoDao dao;
	
	public ControleLinhaExtensao(){
		selecionado = new LinhaExtensao();
		dao = new LinhaExtensaoDao();
	}
	
	public ArrayList<LinhaExtensao> listar(){
            try {
                return (ArrayList<LinhaExtensao>) dao.recuperarTodos();
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Linhas de Extensao.", ""));
                return new ArrayList<LinhaExtensao>();
            }
	}

	public LinhaExtensao getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(LinhaExtensao selecionado) {
		this.selecionado = selecionado;
	}
	
	

}
