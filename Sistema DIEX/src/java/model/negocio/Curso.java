package model.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import model.util.DataUtil;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import control.BaseEntity;

/**
 *
 *
 * @author Jefferson Sales, Fabricio Paes
 */

@Entity
@Table(name="curso", schema="diex")
public class Curso implements Serializable, BaseEntity{
    
    @Transient
    private static final long serialVersionUID = 2209588026843788462L;

    @Id
    @GeneratedValue
    @Column(name="id", nullable=false)
    private int codigo;

    @Column(name="titulo", nullable=false, length=100)
    private String titulo;
    
    @ManyToOne//(fetch=FetchType.EAGER) 
    @JoinColumn(name="responsavel", nullable= false, insertable= true, updatable = true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Servidor proponente;
    
    @ManyToOne//(fetch=FetchType.EAGER) 
    @JoinColumn(name="area_conhecimento", nullable= false, insertable= true, updatable = true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private AreaConhecimento areaConhecimento;
     
    @ManyToOne//(fetch=FetchType.EAGER) 
    @JoinColumn(name="area_tematica", nullable= false, insertable= true, updatable = true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private AreaTematica areaTematica;
    
    @ManyToOne//(fetch=FetchType.EAGER) 
    @JoinColumn(name="linha_extensao", nullable= false, insertable= true, updatable = true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private LinhaExtensao linhaExtensao;
    
    @ManyToOne//(fetch=FetchType.EAGER) 
    @JoinColumn(name="local_realizacao", nullable= false, insertable= true, updatable = true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private LocalRealizacao localRealizacao;
    
    @Column(name="local_externo", length=200)
    private String localExterno;
    
    @Column(name="quantidade_vagas", nullable=false)
    private int numVagas;
    
    @Column(name="publico_alvo", nullable=false, length=100)
    private String publicoAlvo;

    @Column(name="data_inicio", nullable = false, length = 10)
    private String dataIni;

    @Column(name="data_termino", nullable=false, length = 10)
    private String dataFim;
    
    @Column(name="hora_inicio", nullable=false, length=8)
    private String horaIni;
    
    @Column(name="hora_termino", nullable=false, length= 8)
    private String horaFim;
    
    @Column(name="carga_horaria_total", length=5, nullable=false)
    private String cargaHorariaTotal;
    
    @Column(name="carga_horaria_semanal", length=5, nullable=false)
    private String cargaHorariaSemanal;
    
    @Column(name="requisitos_acessos", length=1000)
    private String requisitosAcesso;
    
    @Column(name="justificativa", length = 1000)
    private String justificativa;
    
    @Column(name="objetivo_geral", length=1000)
    private String objetivosGerais;
    
    @Column(name="objetivo_especifico", length= 1000)
    private String objetivosEspecificos;
    
    @Column(name="metodologia", length= 1000)
    private String metodologia;
      
    @Column(name="metas", length= 1000)
    private String metas;
   
    @Column(name="referencias", length = 1000)
    private String referencias;
    
    @Column(name="avaliacao_resultados", length=500)
    private String avaliacaoResultados;
    
    @Column(name="protocolo", length=100)
    private String protocolo;
    
    @Column(name="data_cadastro", nullable=false, length=10)
    private String dataCadastro;
   
    @ManyToMany//(fetch=FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name="equipe_servidores", schema="diex",
            joinColumns={@JoinColumn(name="id_curso")},
            inverseJoinColumns={@JoinColumn(name="id_servidor")})
    private List<Servidor> servidores;
    
    @ManyToMany//(fetch= FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name="matricula", schema="diex",
            joinColumns={@JoinColumn(name="id_curso")}, 
            inverseJoinColumns={@JoinColumn(name="id_aluno")})
    private List<Aluno> discentesMatriculados;
    
    @ManyToMany//(fetch= FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name="equipe_alunos_monitores", schema="diex",
            joinColumns={@JoinColumn(name="id_curso")}, 
            inverseJoinColumns={@JoinColumn(name="id_aluno")})
    private List<Aluno> equipeMonitores;
    
    @OneToMany(mappedBy = "codigoCurso"/*, fetch= FetchType.EAGER*/)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ConteudoProgramatico> conteudoProgramatico;
    
    @OneToMany(mappedBy = "codigoCurso"/*, fetch= FetchType.EAGER*/)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<SolicitacaoEdicao> solicitacaoEdicao;
    
    @Column(name="situacao", nullable=false)
    private int situacao;
    
    @Column(name="dias", nullable=false, length=100)
    private String dias;
    
    public Curso() {
    	super();
    	areaConhecimento = new AreaConhecimento();
    	areaTematica = new AreaTematica();
    	conteudoProgramatico = new ArrayList<ConteudoProgramatico>();
    	discentesMatriculados = new ArrayList<Aluno>();
    	equipeMonitores = new ArrayList<Aluno>();
    	linhaExtensao = new LinhaExtensao();
    	localRealizacao = new LocalRealizacao();
    	proponente = new Servidor();
    	servidores = new ArrayList<Servidor>();
    	solicitacaoEdicao = new ArrayList<SolicitacaoEdicao>();
    }

    public Curso(String titulo, String protocolo, String dataIni,
	    String dataFim, String dataCadastro, Servidor proponente, int situacao) {
        
        super();
        
        DataUtil.validarData(dataCadastro);
        DataUtil.validarData(dataIni);
        DataUtil.validarData(dataFim);

	this.titulo = titulo;
	this.protocolo = protocolo;
        this.dataCadastro= dataCadastro;
	this.dataIni = (dataIni);
	this.dataFim = (dataFim);
	this.proponente = proponente;
	this.situacao = situacao;
    }

    public List<Aluno> getEquipeMonitores() {
        return equipeMonitores;
    }

    public void setEquipeMonitores(List<Aluno> equipeMonitores) {
        this.equipeMonitores = equipeMonitores;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getObjetivosGerais() {
        return objetivosGerais;
    }

    public void setObjetivosGerais(String objetivosGerais) {
        this.objetivosGerais = objetivosGerais;
    }

    public String getObjetivosEspecificos() {
        return objetivosEspecificos;
    }

    public void setObjetivosEspecificos(String objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    
    public String getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(String cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getCodigo() {
	return codigo;
    }

    public String getTitulo() {
	return titulo;
    }

    public String getProtocolo() {
	return protocolo;
    }

    public Servidor getProponente() {
	return proponente;
    }

    public String getMetas() {
	return metas;
    }

    public String getMetodologia() {
	return metodologia;
    }

    public String getJustificativa() {
	return justificativa;
    }

    public String getRequisitosAcesso() {
	return requisitosAcesso;
    }

    public List<Servidor> getServidores() {
	return servidores;
    }

    public List<Aluno> getDiscentesMatriculados() {
	return discentesMatriculados;
    }

    public String getPublicoAlvo() {
	return publicoAlvo;
    }

    public int getNumVagas() {
	return numVagas;
    }

    public LocalRealizacao getLocalRealizacao() {
	return localRealizacao;
    }

    public String getCargaHorariaTotal() {
	return cargaHorariaTotal;
    }

    public String getReferencias() {
	return referencias;
    }

    public AreaConhecimento getAreaConhecimento() {
	return areaConhecimento;
    }

    public AreaTematica getAreaTematica() {
	return areaTematica;
    }

    public LinhaExtensao getLinhaExtensao() {
	return linhaExtensao;
    }

    public List<ConteudoProgramatico> getConteudoProgramatico() {
	return conteudoProgramatico;
    }

    public String getAvaliacaoResultados() {
	return avaliacaoResultados;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public void setProtocolo(String protocolo) {
	this.protocolo = protocolo;  
    
    }

    public void setProponente(Servidor proponente) {
	this.proponente = proponente;
    }

    public void setMetas(String metas) {
	this.metas = metas;
    }

    public void setMetodologia(String metodologia) {
	this.metodologia = metodologia;
    }
    
    public void setJustificativa(String justificativa) {
	this.justificativa = justificativa;
    }

    public void setRequisitosAcesso(String requisitosAcesso) {
	this.requisitosAcesso = requisitosAcesso;
    }

    public void setPublicoAlvo(String publicoAlvo) {
	this.publicoAlvo = publicoAlvo;
    }

    public void setNumVagas(int numVagas) {
	this.numVagas = numVagas;
    }

    public void setLocalRealizacao(LocalRealizacao localRealizacao) {
	this.localRealizacao = localRealizacao;
    }

    public void setCargaHorariaTotal(String cargaHorariaTotal) {
	this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public void setReferencias(String referencias) {
	this.referencias = referencias;
    }

    public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
	this.areaConhecimento = areaConhecimento;
    }

    public void setAreaTematica(AreaTematica areaTematica) {
	this.areaTematica = areaTematica;
    }

    public void setLinhaExtensao(LinhaExtensao linhaExtensao) {
	this.linhaExtensao = linhaExtensao;
    }
    
    public void setConteudoProgramatico(List<ConteudoProgramatico> conteudoProgramatico) {
	this.conteudoProgramatico = conteudoProgramatico;
    }

    public void setAvaliacaoResultados(String avaliacaoResultados) {
	this.avaliacaoResultados = avaliacaoResultados;
    }

    public void setDiscentesMatriculados(List<Aluno> discentesMatriculados) {
	this.discentesMatriculados = discentesMatriculados;
    }

    public String getDataIni() {
	return dataIni;
    }

    public String getDataFim() {
	return dataFim;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }
    
    public String getLocalExterno() {
        return localExterno;
    }

    public void setLocalExterno(String localExterno) {
        this.localExterno = localExterno;
    }
    
    public String getDias(){
    	return dias;
    }
    
    public void setDias(String dias){
    	this.dias = dias;
    }

	public List<SolicitacaoEdicao> getSolicitacaoEdicao() {
		return solicitacaoEdicao;
	}

	public void setSolicitacaoEdicao(List<SolicitacaoEdicao> solicitacaoEdicao) {
		this.solicitacaoEdicao = solicitacaoEdicao;
	}

	@Override
	public Integer getId() {
		return codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (codigo != other.getCodigo())
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.getTitulo()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return titulo;
	}

	
}
