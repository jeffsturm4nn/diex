package control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.DAO.AlunoDao;
import model.DAO.CursoDao;
import model.negocio.Aluno;
import model.negocio.Curso;

@ManagedBean
@SessionScoped
public class ControleMatricula {
	
	private String cpf;
	
	private Aluno aluno;
	private AlunoDao alunoDao;
	
	private Curso curso;
	private List<Curso> cursos;
	private CursoDao cursoDao;

	public ControleMatricula(){
		aluno = new Aluno();
		alunoDao = new AlunoDao();
		curso = new Curso();
		cursos = new ArrayList<Curso>();
		cursoDao = new CursoDao();
	}
	
	public boolean buscarAluno(){
		aluno = alunoDao.recuperarPorCpf(cpf);
		if(aluno != null){
			return true;
		}
		
		FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage("Nenhum aluno encontrado. "));
		
		return false;
	}
	
	public String adicionar() {
		List<Aluno> temporario = new ArrayList<Aluno>();
		
        try {
        	aluno.setCursosMatriculados(cursos);
            alunoDao.alterar(aluno);
        } catch (Exception ex) {
        	ex.printStackTrace();
            /*FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao alterar o Aluno.", ""));
            return "";*/
        }

        for (int i = 0; i < cursos.size(); i++) {
            try {
                curso = cursoDao.recuperarPorId(cursos.get(i).getCodigo());
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao obter os dados do Curso.", ""));
                return "";
            }
            
            if (curso.getDiscentesMatriculados() != null) {
                temporario = new ArrayList<Aluno>(curso.getDiscentesMatriculados());
            }
            temporario.add(aluno);
            cursos.get(i).setDiscentesMatriculados(temporario);
            curso = cursos.get(i);
            try {
                cursoDao.alterar(curso);
            } catch (Exception ex) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao alterar o Curso.", ""));
                return "";
            }
        }

        return "/index.xhtml?faces-redirect=true";
    }


	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public Curso getCurso(){
		return curso;
	}
	
	public void setCurso(Curso curso){
		this.curso = curso;
	}
	
}
