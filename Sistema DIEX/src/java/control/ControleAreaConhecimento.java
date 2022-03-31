package control;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;

/**
 * @author Alexandre Jorge
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.AreaConhecimentoDao;
import model.negocio.AreaConhecimento;

/**
 * 
 * @author Alexandre Jorge
 *
 */

@ManagedBean
@RequestScoped
@SuppressWarnings("static-method")
public class ControleAreaConhecimento {
	
	private AreaConhecimento selecionado;
	private AreaConhecimentoDao dao;
	
	public ControleAreaConhecimento(){
		selecionado = new AreaConhecimento();
		dao = new AreaConhecimentoDao();
	}
	
	public ArrayList<AreaConhecimento> listar() {
            try {
                return (ArrayList<AreaConhecimento>) dao.recuperarTodos();
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Areas de Conhecimento.", ""));
                return new ArrayList<AreaConhecimento>();
            }
	}

	public AreaConhecimento getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(AreaConhecimento selecionado) {
		this.selecionado = selecionado;
	}
	
	

}
