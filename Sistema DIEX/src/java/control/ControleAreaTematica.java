package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

/**
 * @author Alexandre Jorge
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.AreaTematicaDao;
import model.negocio.AreaTematica;

/**
 *
 * @author Alexandre Jorge
 *
 */
@ManagedBean
@RequestScoped
@SuppressWarnings("static-method")
public class ControleAreaTematica {

    private AreaTematica selecionado;
    private AreaTematicaDao dao;

    public ControleAreaTematica() {
        selecionado = new AreaTematica();
        dao = new AreaTematicaDao();
    }

    public ArrayList<AreaTematica> listar() {
        try {
            return (ArrayList<AreaTematica>) dao.recuperarTodos();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Areas Tematicas.", ""));
            return new ArrayList<AreaTematica>();
        }
    }

    public AreaTematica getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(AreaTematica selecionado) {
        this.selecionado = selecionado;
    }
}
