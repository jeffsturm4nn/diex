package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.TipoServidorDao;
import model.negocio.TipoServidor;

/**
 * 
 * @author Alexandre Jorge
 *
 */

@ManagedBean
@RequestScoped
@SuppressWarnings("static-method")

public class ControleTipoServidor {

	private TipoServidor selecionado;
	private TipoServidorDao dao;
	
	public ControleTipoServidor() {
		super();
		this.selecionado = new TipoServidor();
		this.dao = new TipoServidorDao();
	}
	
	public ArrayList<TipoServidor> listar(){
            try {
                return (ArrayList<TipoServidor>) dao.recuperarTodos();
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Tipos de Servidor.", ""));
                return new ArrayList<TipoServidor>();
            }
	}
	
	public TipoServidor getSelecionado(){
		return selecionado;
	}
	
	public void setSelecionado(TipoServidor selecionado){
		this.selecionado = selecionado;
	}
	
}

