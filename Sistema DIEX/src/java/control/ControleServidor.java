package control;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.ServidorDao;
import model.negocio.Servidor;
import model.util.DataUtil;
import model.util.EmailUtil;

/**
 *
 * @author Fabricio Paes, Jefferson Sales, Alexandre Jorge
 */
@ManagedBean
@RequestScoped
@SuppressWarnings("static-method")
public class ControleServidor {

    private Servidor selecionado;
    private List<Servidor> listaFiltrados;
    private ServidorDao dao;
    private Servidor servidor;

    public ControleServidor() {

        servidor = new Servidor();
        selecionado = null;
        dao = new ServidorDao();
        listaFiltrados = new ArrayList<Servidor>();
    }

    public String visualizar() {
        return "DadosServidor";
    }

    public String adicionar() {
    	
    	try{
    		EmailUtil.validarEmail(servidor.getEmail());
    	} catch (IllegalArgumentException e) {
    		FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "EMAIL Inválido", ""));
            return "";
    	}
    	
        servidor.setAtivo(1);
        servidor.setDataCadastro(DataUtil.dataAtual());
        try {
            servidor.setCodigo(dao.adicionar(servidor));
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao salvar o Servidor.", ""));
            return "";
        }
        return "/ListarServidores.xhtml?faces-redirect=true";
    }

    public String alterar() {
    	
    	try{
    		EmailUtil.validarEmail(servidor.getEmail());
    	} catch (IllegalArgumentException e) {
    		FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "EMAIL Inválido", ""));
            return "";
    	}
    	
        servidor.setAtivo(1);
        try {
            dao.alterar(servidor);
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao alterar o Servidor.", ""));
            return "";
        }
        return "/ListarServidores.xhtml?faces-redirect=true";
    }

    public String preparaCadastro() {
        servidor = new Servidor();
        return "/CadastroServidor.xhtml?faces-redirect=true";
    }

    public String preparaVisualizacao() {
        servidor = selecionado;
        return "/DadosServidor.xhtml";
    }

    public String preparaEdicao() {
        servidor = selecionado;
        servidor.setDataCadastro(selecionado.getDataCadastro());
        return "/EdicaoServidor.xhtml";
    }

    public void remover() {
        if (selecionado != null) {
            try {
                dao.remover(selecionado.getCodigo());
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao remover o Servidor.", ""));
                return;
            }
            listaFiltrados.remove(selecionado);
            selecionado = null;
            return;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione o servidor a ser removido.", ""));
    }

    public List<Servidor> listar() {
        ArrayList<Servidor> lista = new ArrayList<Servidor>();
        try {
            for (int i = 0; i < dao.recuperarTodos().size(); i++) {
                Servidor obj = dao.recuperarTodos().get(i);
                if (obj.getAtivo() == 1) {
                    lista.add(obj);
                }
            }
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Servidores.", ""));
            return new ArrayList<Servidor>();
        }

        listaFiltrados = new ArrayList<Servidor>(lista);

        return lista;
    }

    public Servidor getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Servidor selecionado) {
        this.selecionado = selecionado;
    }

    public List<Servidor> getListaFiltrados() {
        return listaFiltrados;
    }

    public void setListaFiltrados(ArrayList<Servidor> listaFiltrados) {
        this.listaFiltrados = listaFiltrados;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }
}
