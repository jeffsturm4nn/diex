package model.negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import control.BaseEntity;

import model.util.CpfUtil;
import model.util.EmailUtil;
import model.util.RgUtil;

/**
 *
 *
 * @author Jefferson Sales
 */

@Entity
@Table(name= "aluno", schema = "diex")
public class Aluno implements Serializable, BaseEntity {

    @Transient
    private static final long serialVersionUID = -8719935926213371939L;

    @Id
    @GeneratedValue
    @Column(name= "id", nullable= false)
    private int codigo;

    @Column(name= "nome", nullable= false, length = 100)
    private String nome;

    @Column(name= "sexo", nullable= false)
    private String sexo;

    @Column(name= "cpf", nullable= false, length = 14)
    private String numCpf;

    @Column(name= "rg", nullable= false, length = 9)
    private String numRg;
	
    @Column(name = "orgao_expedidor", length = 10)
    private String orgaoExpeditor;
	
    @Column(name= "data_nascimento", nullable = false, length = 10)
    private String dataNasc;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "profissao", length = 100)
    private String profissao;
	
    @Column(name = "fone", length = 20)
    private String telefoneFixo;

    @Column(name = "celular", length = 20)
    private String telefoneCelular;

    @OneToOne(cascade = CascadeType.ALL/*, fetch = FetchType.EAGER*/)
    @JoinColumn(name = "perfil", nullable = false, insertable = true, updatable = true)
    private PerfilCandidato perfilCandidato;

    @OneToOne(cascade = CascadeType.ALL/*, fetch = FetchType.EAGER*/)
    @JoinColumn(name = "escolaridade", nullable = false, insertable = true, updatable = true)
    private Escolaridade escolaridade;

    @OneToOne(cascade = CascadeType.ALL/*, fetch = FetchType.EAGER*/)
    @JoinColumn(name = "endereco", nullable = false, insertable = true, updatable = true)
    private Endereco endereco;
    
    @Column(name = "foi_informado", length = 500)
    private String foiInformado;
	
    @Column(name = "data_cadastro", length = 10, nullable = false)
    private String dataCadastro;
    
    @ManyToMany//(fetch= FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name="matricula", schema="diex",
                joinColumns=@JoinColumn(name="id_aluno"),
                inverseJoinColumns=@JoinColumn(name="id_curso"))
    private List<Curso> cursosMatriculados;
    
    @ManyToMany//(fetch= FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name="equipe_alunos_monitores", schema="diex",
                joinColumns=@JoinColumn(name="id_aluno"),
                inverseJoinColumns=@JoinColumn(name="id_curso"))
    private List<Curso> cursosMonitorados;
    
    @Column(name = "ativo", nullable = false)
    private int ativo;
    
    public Aluno() {
    	super();
    	this.escolaridade = new Escolaridade();
    	this.perfilCandidato = new PerfilCandidato();
    	this.endereco = new Endereco();
    }

    public Aluno(String nome, String sexo, String numCpf, String numRg, 
    		String orgaoExpeditor, String dataNasc, String email, 
			String profissao, String telefoneFixo, String telefoneCelular,
			PerfilCandidato perfilCandidato, Escolaridade escolaridade,
			Endereco endereco, String foiInformado, String dataCadastro) {
    	
	super();
		
	RgUtil.validarRG(numRg);
	CpfUtil.validarCpf(numCpf);
	EmailUtil.validarEmail(email);

	this.nome = nome;
	this.sexo = sexo;
	this.numCpf = numCpf;
	this.numRg = numRg;
	this.orgaoExpeditor = orgaoExpeditor;
	this.dataNasc = dataNasc;
	this.email = email;
	this.profissao = profissao;
	this.telefoneFixo = telefoneFixo;
	this.telefoneCelular = telefoneCelular;
	this.perfilCandidato = perfilCandidato;
	this.escolaridade = escolaridade;
	this.endereco = endereco;
	this.foiInformado = foiInformado;
	this.dataCadastro = dataCadastro;
	this.ativo = 1;
    }

    public List<Curso> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void setCursosMatriculados(List<Curso> cursosMatriculados) {
        this.cursosMatriculados = cursosMatriculados;
    }

    public List<Curso> getCursosMonitorados() {
        return cursosMonitorados;
    }

    public void setCursosMonitorados(List<Curso> cursosMonitorados) {
        this.cursosMonitorados = cursosMonitorados;
    }

    
    public String getNome() {
    	return nome;
    }

    public String getSexo() {
    	return sexo;
    }

    public String getDataNasc() {
    	return dataNasc;
    }

    public String getNumRg() {
    	return numRg;
    }

    public String getNumCpf() {
    	return numCpf;
    }

    public Endereco getEndereco() {
    	return endereco;
    }

    public PerfilCandidato getPerfilCandidato() {
    	return perfilCandidato;
    }

    public Escolaridade getEscolaridade() {
    	return escolaridade;
    }

    public String getProfissao() {
    	return profissao;
    }

    public void setEndereco(Endereco endereco) {
    	this.endereco = endereco;
    }

    public void setPerfilCandidato(PerfilCandidato perfilCandidato) {
    	this.perfilCandidato = perfilCandidato;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
    	this.escolaridade = escolaridade;
    }

    public void setProfissao(String profissao) {
    	this.profissao = profissao;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setNumRg(String numRg) {
        this.numRg = numRg;
    }

    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }

    public int getAtivo() {
        return this.ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getTelefoneFixo() {
    	return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
    	this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
    	return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCellular) {
    	this.telefoneCelular = telefoneCellular;
    }

    public int getCodigo() {
    	return codigo;
    }

    public void setCodigo(int codigo) {
    	this.codigo = codigo;
    }

    public String getOrgaoExpeditor() {
	return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
	this.orgaoExpeditor = orgaoExpeditor;
    }

    public String getFoiInformado() {
	return foiInformado;
    }

    public void setFoiInformado(String foiInformado) {
	this.foiInformado = foiInformado;
    }

    public String getDataCadastro() {
	return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
	this.dataCadastro = dataCadastro;
    }
    
    @Override
	public String toString() {
		return nome;
	}

	@Override
	public Integer getId() {
		return codigo;
	}
}
