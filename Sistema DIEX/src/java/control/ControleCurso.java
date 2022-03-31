package control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;

import org.primefaces.model.DualListModel;

import model.DAO.AlunoDao;
import model.DAO.ConteudoProgramaticoDao;
import model.DAO.CursoDao;
import model.DAO.ServidorDao;
import model.DAO.SolicitacaoEdicaoDao;
import model.negocio.Aluno;
import model.negocio.ConteudoProgramatico;
import model.negocio.Curso;
import model.negocio.Servidor;
import model.negocio.SolicitacaoEdicao;
import model.util.DataUtil;
import model.util.HoraUtil;

/**
 * 
 * @author Alexandre Jorge
 *
 */

@ManagedBean
@SessionScoped
@SuppressWarnings("static-method")
public class ControleCurso {
	
	private Curso curso;
	private Curso selecionado;
	private CursoDao dao;
	private ArrayList<Curso> listaFiltrados;
	
	private ConteudoProgramatico conteudo;
	private ConteudoProgramaticoDao conteudoDao;
	private List<ConteudoProgramatico> conteudoProgramatico;
	private List<ConteudoProgramatico> conteudosExcluidos;
	private List<ConteudoProgramatico> conteudosNovos;
	
	private SolicitacaoEdicao solicitacao;
	private SolicitacaoEdicaoDao solicitacaoDao;
	private List<SolicitacaoEdicao> solicitacoes;

	private DualListModel<Aluno> monitores;
	private AlunoDao alunoDao = new AlunoDao();
	private List<Aluno> alunosAtivos;
	private List<Aluno> monitoresEscolhidos;
	
	private DualListModel<Servidor> servidores;
	private ServidorDao servidorDao = new ServidorDao();
	private List<Servidor> servidoresAtivos;
	private List<Servidor> servidoresEscolhidos;
	
	private SelectItem[] situacoes;
	
	private boolean correcao;
	
	/*---------------------------------------*/
	
    public ControleCurso() {

        curso = new Curso();
        selecionado = null;
        dao = new CursoDao();

        List<Aluno> listaAlunos = new ArrayList<Aluno>();
        try {
            for (int i = 0; i < alunoDao.recuperarTodos().size(); i++) {
                Aluno obj = alunoDao.recuperarTodos().get(i);
                if (obj.getAtivo() == 1) {
                    listaAlunos.add(obj);
                }
            }
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Cursos.", ""));
        }
        alunosAtivos = new ArrayList<Aluno>(listaAlunos);

        List<Servidor> listaServidores = new ArrayList<Servidor>();
        try {
            for (int i = 0; i < servidorDao.recuperarTodos().size(); i++) {
                Servidor obj = servidorDao.recuperarTodos().get(i);
                if (obj.getAtivo() == 1) {
                    listaServidores.add(obj);
                }
            }
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Servidores.", ""));
        }
        servidoresAtivos = new ArrayList<Servidor>(listaServidores);

        conteudo             = new ConteudoProgramatico();
        conteudoDao          = new ConteudoProgramaticoDao();
        conteudoProgramatico = new ArrayList<ConteudoProgramatico>();
        conteudosExcluidos   = new ArrayList<ConteudoProgramatico>();
        conteudosNovos       = new ArrayList<ConteudoProgramatico>();
        
        solicitacao = new SolicitacaoEdicao();
        solicitacaoDao = new SolicitacaoEdicaoDao();
        solicitacoes = new ArrayList<SolicitacaoEdicao>();

        monitoresEscolhidos = new ArrayList<Aluno>();
        servidoresEscolhidos = new ArrayList<Servidor>();

        monitores = new DualListModel<Aluno>(alunosAtivos, monitoresEscolhidos);
        servidores = new DualListModel<Servidor>(servidoresAtivos, servidoresEscolhidos);
        
        correcao = false;

        this.situacoes = new SelectItem[]{
            new SelectItem(" ", " "),
            new SelectItem(" CADASTRADO", " CADASTRADO"),
            new SelectItem(" A SER CORRIGIDO", " A SER CORRIGIDO"),
            new SelectItem(" CORRIGIDO", " CORRIGIDO"),
            new SelectItem(" EM ABERTO", " EM ABERTO"),
            new SelectItem(" REJEITADO", " REJEITADO"),
            new SelectItem(" INICIADO", " INICIADO"),
            new SelectItem(" FINALIZADO", " FINALIZADO"),
            new SelectItem(" CANCELADO", " CANCELADO")
        };
    }
	
	public String reinit() {  
        conteudo = new ConteudoProgramatico();          
        return null;  
    }
	
	public String adicionar() {
		try{
			DataUtil.validarData(curso.getDataIni());
		} catch (IllegalArgumentException e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data de Inicio Inválida", ""));
            return "";
		}
		
		try{
			DataUtil.validarData(curso.getDataFim());
		} catch (IllegalArgumentException e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data de Término Inválida", ""));
            return "";
		}
		
        curso.setDataCadastro(DataUtil.dataAtual());
        curso.setSituacao(1);
        curso.setEquipeMonitores(monitores.getTarget());
        curso.setServidores(servidores.getTarget());
        try {
            curso.setCodigo(dao.adicionar(curso));
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao salvar o Curso.", ""));
            return "";
        }
        return "/CadastroConteudoProgramatico.xhtml?faces-redirect=true";
    }
	
	public String adicionarConteudoProgramatico(){
		
		try {
            for (int i = 0; i < conteudoProgramatico.size(); i++) {
                conteudoProgramatico.get(i).setCodigoCurso(curso);
                conteudoDao.adicionar(conteudoProgramatico.get(i));
            }
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao adicionar o Conteudo Programatico no Curso.", ""));
        }
		
		selecionado = null;
        curso.setConteudoProgramatico(conteudoProgramatico);
		return "/ListarCursos.xhtml";
	}
	
	public String adicionarSolicitacao(){
		solicitacoes = curso.getSolicitacaoEdicao();
		solicitacoes.add(solicitacao);
		try{
			solicitacao.setCodigoCurso(curso);
			solicitacaoDao.adicionar(solicitacao);
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao enviar a solicitacao", ""));
		}
		
		try {
			curso.setSituacao(2);
			dao.alterar(curso);
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao alterar o curso", ""));
		}
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage("A solicitação foi enviada ao proponente."));
		return "/ListarCursos.xhtml";
	}
	
	public String alterar() {
        curso.setEquipeMonitores(monitores.getTarget());
        curso.setServidores(servidores.getTarget());
        curso.setConteudoProgramatico(conteudoProgramatico);
        
        if(curso.getSolicitacaoEdicao() == null){
        	curso.setSituacao(3);
        }
        
        try {
            dao.alterar(curso);
        } catch (Exception ex) {
        	FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao alterar Curso.", ""));
            return "";
        }
        
        selecionado = null;
        return "/ListarCursos.xhtml?faces-redirect=true";
    }
	
	public String alterarConteudoProgramatico(){

            try {
            	for(int i = 0; i < conteudosNovos.size(); i++){
        			conteudosNovos.get(i).setCodigoCurso(curso);
        			conteudoDao.adicionar(conteudosNovos.get(i));
            }
			} catch (Exception e) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro no cadastro do Conteudo Programatico.", ""));
			}
		
		try{
			for(int i = 0; i < conteudosExcluidos.size(); i++){
				if(conteudosExcluidos.get(i).getCodigoCurso() != null)
					conteudoDao.remover(conteudosExcluidos.get(i).getCodigoConteudo());
			}
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro na remoção do Conteudo Programatico.", ""));
		}
		
		//curso.setConteudoProgramatico(conteudoProgramatico);
		
		return "/EdicaoCurso.xhtml";
	}
	
	public boolean permicaoEditar() { return true; }
	public boolean permicaoExcluir() { return true; }
		
	public ArrayList<Curso> listar() {
        try {
            return (ArrayList<Curso>) dao.recuperarTodos();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Cursos.", ""));
            return new ArrayList<Curso>();
        }
    }
	
	public ArrayList<Curso> listarMatriculaveis() {
        ArrayList<Curso> matriculaveis = new ArrayList<Curso>();
        try {
            listaFiltrados = (ArrayList<Curso>) dao.recuperarTodos();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Cursos.", ""));
        }
        for (int i = 0; i < listaFiltrados.size(); i++) {
        	try {
        		if (listaFiltrados.get(i).getSituacao() == 4) {
        			matriculaveis.add(listaFiltrados.get(i));
        		}
            } catch (Exception e) {
            	FacesContext ctx = FacesContext.getCurrentInstance();
            	ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter a lista de Cursos Matriculaveis.", ""));
            }
        }
        
        return matriculaveis;
    }
	
	public String preparaCadastro(){
		curso = new Curso();
		conteudo = new ConteudoProgramatico();
		conteudoProgramatico = new ArrayList<ConteudoProgramatico>();
		monitoresEscolhidos = new ArrayList<Aluno>();
        servidoresEscolhidos = new ArrayList<Servidor>();
        monitores = new DualListModel<Aluno>(alunosAtivos, monitoresEscolhidos);
        servidores = new DualListModel<Servidor>(servidoresAtivos, servidoresEscolhidos);
		return "/CadastroCurso.xhtml?faces-redirect=true";
	}
	
	public String preparaEdicao() {

        if (selecionado == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione o curso a ser editado.", ""));
            return "";
        }
        
        try {
            curso = dao.recuperarPorId(selecionado.getCodigo());
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados do Curso.", ""));
            return "";
        }
        
        List<Servidor> tempServidor = curso.getServidores();
        List<Aluno> tempAluno = curso.getEquipeMonitores();

        servidoresEscolhidos = new ArrayList<Servidor>();
        
        try {
            for (int i = 0; i < tempServidor.size(); i++) {
                servidoresEscolhidos.add(servidorDao.recuperarPorId(curso.getServidores().get(i).getCodigo()));
            }
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados do Professor.", ""));
            return "";
        }

        for (int i = 0; i < servidoresAtivos.size(); i++) {
            for (int j = 0; j < tempServidor.size(); j++) {
                if (tempServidor.get(j).equals(servidoresAtivos.get(i))) {
                    servidoresAtivos.remove(i);
                }
            }
        }

        servidores = new DualListModel<Servidor>(servidoresAtivos, servidoresEscolhidos);

        monitoresEscolhidos = new ArrayList<Aluno>();
        
        try {
            for (int i = 0; i < tempAluno.size(); i++) {
                monitoresEscolhidos.add(alunoDao.recuperarPorId(curso.getEquipeMonitores().get(i).getCodigo()));
            }
        } catch (Exception e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados do Aluno Monitor.", ""));
            return "";
        }

        for (int i = 0; i < alunosAtivos.size(); i++) {
            for (int j = 0; j < tempAluno.size(); j++) {
                if (tempAluno.get(j).equals(alunosAtivos.get(i))) {
                    alunosAtivos.remove(i);
                }
            }
        }

        monitores = new DualListModel<Aluno>(alunosAtivos, monitoresEscolhidos);
        
        conteudoProgramatico = curso.getConteudoProgramatico();
        
		return "/EdicaoCurso.xhtml?faces-redirect=true";
	}
	
	public String preparaEdicaoConteudo(){
		conteudosExcluidos = new ArrayList<ConteudoProgramatico>();
        conteudosNovos = new ArrayList<ConteudoProgramatico>();
        try {
			curso = dao.recuperarPorId(selecionado.getCodigo());
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados do Curso.", ""));
            return "";
		}
        return "/EdicaoConteudoProgramatico.xhtml";
	}
	
	public String preparaVisualizacao() {
        if (selecionado != null) {
            try {
                curso = dao.recuperarPorId(selecionado.getCodigo());
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados do Curso.", ""));
                return "";
            }
            return "/DadosCurso.xhtml?faces-redirect=true";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione o curso a ser visualizado.", ""));
        return "";
    }
	
	public void remover() {
        if (selecionado != null) {
            try {
                dao.remover(selecionado.getCodigo());
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao remover o Curso.", ""));
                return;
            }
            listaFiltrados.remove(selecionado);
            return;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione o curso a ser removido.", ""));
    }
	
	public void removerConteudo() {
		try {
			conteudoDao.remover(conteudo.getCodigoConteudo());
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione o curso a ser removido.", ""));
		}
	}
	
	public String aprovarCurso() {
        Curso temp;
        try {
            temp = dao.recuperarPorId(curso.getCodigo());
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados do Curso.", ""));
            return "";
        }
        
        temp.setSituacao(4);
        try {
            dao.alterar(temp);
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao alterar o Curso.", ""));
            return "";
        }
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "O curso foi APROVADO e aberto para matrículas.", ""));
        
        selecionado = null;
        
        return "/ListarCursos.xhtml?faces-redirect=true";
    }
	
	public String rejeitarCurso(){
		Curso temp;
		try {
			temp = dao.recuperarPorId(curso.getCodigo());
		} catch (Exception ex) {
			FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados do Curso.", ""));
            return "";
		}
		temp.setSituacao(7);
		try {
			dao.alterar(temp);
		} catch (Exception ex) {
			FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao alterar o Curso.", ""));
            return "";
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("O Curso foi REJEITADO"));
		
        selecionado = null;
        
		return "/ListarCursos.xhtml?faces-redirect=true";
	}
	
	public String situacaoString(int situacao){
		return situacoes[situacao].getLabel();
	}
	
	public void solicitouCorrecao(){
		correcao = true;
	}
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Curso getSelecionado() {
		return selecionado;
	}
	public void setSelecionado(Curso selecionado) {
		this.selecionado = selecionado;
	}
	public ArrayList<Curso> getListaFiltrados() {
		return listaFiltrados;
	}
	public void setListaFiltrados(ArrayList<Curso> listaFiltrados) {
		this.listaFiltrados = listaFiltrados;
	}

	public ConteudoProgramatico getConteudo() {
		return conteudo;
	}
	public void setConteudo(ConteudoProgramatico conteudo) {
		this.conteudo = conteudo;
	}

	public DualListModel<Aluno> getMonitores() {
		return monitores;
	}

	public void setMonitores(DualListModel<Aluno> monitores) {
		this.monitores = monitores;
	}

	public DualListModel<Servidor> getServidores() {
		return servidores;
	}

	public void setServidores(DualListModel<Servidor> servidores) {
		this.servidores = servidores;
	}
	
	public List<ConteudoProgramatico> getConteudoProgramatico() {
		return conteudoProgramatico;
	}

	public void setConteudoProgramatico(
			List<ConteudoProgramatico> conteudoProgramatico) {
		this.conteudoProgramatico = conteudoProgramatico;
	}

	public SelectItem[] getSituacoes() {
		return situacoes;
	}

	public void setSituacoes(SelectItem[] situacoes) {
		this.situacoes = situacoes;
	}

	public SolicitacaoEdicao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoEdicao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public SolicitacaoEdicaoDao getSolicitacaoDao() {
		return solicitacaoDao;
	}

	public void setSolicitacaoDao(SolicitacaoEdicaoDao solicitacaoDao) {
		this.solicitacaoDao = solicitacaoDao;
	}

	public List<SolicitacaoEdicao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoEdicao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public List<ConteudoProgramatico> getConteudosExcluidos() {
		return conteudosExcluidos;
	}

	public void setConteudosExcluidos(List<ConteudoProgramatico> conteudosExcluidos) {
		this.conteudosExcluidos = conteudosExcluidos;
	}

	public List<ConteudoProgramatico> getConteudosNovos() {
		return conteudosNovos;
	}

	public void setConteudosNovos(List<ConteudoProgramatico> conteudosNovos) {
		this.conteudosNovos = conteudosNovos;
	}

	public boolean isCorrecao() {
		return correcao;
	}

	public void setCorrecao(boolean correcao) {
		this.correcao = correcao;
	}
	
}
