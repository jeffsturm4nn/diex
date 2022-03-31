package control;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAO.AlunoDao;
import model.negocio.Aluno;
import model.util.CpfUtil;
import model.util.DataUtil;
import model.util.EmailUtil;

/**
 *
 * @author Fabricio Paes, Jefferson Sales, Alexandre Jorge
 */
@ManagedBean
@RequestScoped //@SessionScoped
@SuppressWarnings("static-method")
public class ControleAluno {

    private Aluno selecionado;
    private List<Aluno> listaFiltrados;
    private AlunoDao dao;
    private Aluno aluno;

    public ControleAluno() {
        aluno = new Aluno();
        selecionado = null;
        dao = new AlunoDao();
        List<Aluno> filtrados = new ArrayList<Aluno>();
        
        try {
            for (Aluno a : dao.recuperarTodos()) {
                if (a.getAtivo() == 1) {
                    filtrados.add(a);
                }
            }
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Alunos.", ""));
            filtrados = new ArrayList<Aluno>();
        }
        
        listaFiltrados = new ArrayList<Aluno>(filtrados);
    }

    public String adicionar() {
    	try{
    		CpfUtil.validarCpf(aluno.getNumCpf());
    	} catch (IllegalArgumentException e) {
    		FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inválido", ""));
            return "";
    	}
    	
    	try{
    		DataUtil.validarData(aluno.getDataNasc());
    	} catch (IllegalArgumentException e) {
    		FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data de Nascimento Inválida", ""));
            return "";
    	}
    	
    	try{
    		EmailUtil.validarEmail(aluno.getEmail());
    	} catch (IllegalArgumentException e) {
    		FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email Inválido", ""));
            return "";
    	}
    	
    	aluno.setDataCadastro(DataUtil.dataAtual());
        aluno.setAtivo(1);        
        try {
            aluno.setCodigo(dao.adicionar(aluno));
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao salvar o Aluno.", ""));
        }
        return "/ListarAlunos.xhtml?faces-redirect=true";
    }

    public String alterar() {
    	
    	try{
    		CpfUtil.validarCpf(aluno.getNumCpf());
    	} catch (IllegalArgumentException e) {
    		FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inválido", ""));
            return "";
    	}
    	
    	try{
    		DataUtil.validarData(aluno.getDataNasc());
    	} catch (IllegalArgumentException e) {
    		FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data de Nascimento Inválida", ""));
            return "";
    	}
    	
    	try{
    		EmailUtil.validarEmail(aluno.getEmail());
    	} catch (IllegalArgumentException e) {
    		FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email Inválido", ""));
            return "";
    	}
    	
        aluno.setAtivo(1);
        try {
            dao.alterar(aluno);
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao alterar o Aluno.", ""));
        }
        return "/ListarAlunos.xhtml?faces-redirect=true";
    }

    public String preparaCadastro() {
        aluno = new Aluno();
        return "/CadastroAluno.xhtml?faces-redirect=true";
    }

    public String preparaVisualizacao() {
        try {
            aluno = dao.recuperarPorId(selecionado.getCodigo());
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados do Aluno.", ""));
        }
        return "/DadosAluno.xhtml";
    }

    public String preparaEdicao(){
        try {
            aluno = dao.recuperarPorId(selecionado.getCodigo());
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados o Aluno.", ""));
        }
        aluno.setDataCadastro(selecionado.getDataCadastro());
        return "/EdicaoAluno.xhtml";
    }

    public void remover() {
        
        if (selecionado != null) {
            try {
                dao.remover(selecionado.getCodigo());
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao remover o Aluno.", ""));
            }
            listaFiltrados.remove(selecionado);
            return;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione o aluno a ser removido.", ""));
    }

    public List<Aluno> listar() {
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        try {
            for (int i = 0; i < dao.recuperarTodos().size(); i++) {
                Aluno obj = dao.recuperarTodos().get(i);
                if (obj.getAtivo() == 1) {
                    lista.add(obj);
                }
            }
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Alunos.", ""));
        }
        return lista;
    }

    public Aluno getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Aluno selecionado) {
        this.selecionado = selecionado;
    }

    public List<Aluno> getListaFiltrados() {
        return listaFiltrados;
    }

    public void setListaFiltrados(List<Aluno> listaFiltrados) {
        this.listaFiltrados = listaFiltrados;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
