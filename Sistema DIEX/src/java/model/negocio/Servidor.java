package model.negocio;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import model.util.*;
import org.hibernate.annotations.*;

import control.BaseEntity;

/**
 *
 *
 * @author Jefferson Sales
 */
@Entity
@Table(name="servidor", schema = "diex")
public class Servidor implements Serializable, BaseEntity {
	
    @Transient
    private static final long serialVersionUID = -1608369009651899048L;
    
    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private int codigo;
    
    @Column(name="nome", nullable = false, length = 100)
    private String nome;

    @OneToOne(cascade= CascadeType.ALL/*, fetch = FetchType.EAGER*/)
    @JoinColumn(name="usuario", nullable = false, insertable = true, updatable = true)
    private Usuario usuario;
    
    @Column(name="email", nullable = false, length = 60)
    private String email;
    
    @Column(name="fone", length = 20)
    private String telefone;

    @ManyToOne//(fetch = FetchType.EAGER) 
    @JoinColumn(name="tipo_servidor", nullable= false, insertable= true, updatable = true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private TipoServidor tipoServidor;
    
    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name="coordenacao", nullable= false, insertable= true, updatable = true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Coordenacao coordenacao;
    
    @Column(name="unidade_ensino", nullable = false, length = 100)
    private String unidadeEnsino;
    
    @Column(name="data_cadastro", nullable = false, length = 10)
    private String dataCadastro;
    
    @OneToMany(mappedBy = "proponente"/*, fetch = FetchType.EAGER*/)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Curso> cursosMinistrados;
    
    @ManyToMany//(fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name="equipe_servidores", schema="diex",
            joinColumns={@JoinColumn(name="id_servidor")}, 
            inverseJoinColumns={@JoinColumn(name="id_curso")})
    private List<Curso> equipeServidores;
    
    @Column(name="ativo", nullable = false)
    private int ativo;
    
    public Servidor() {
    	super();
    	this.usuario = new Usuario();
    }
    
    public Servidor(String nome, Usuario usuario, String email,
			String telefone, TipoServidor tipoServidor,
			Coordenacao coordenacao, String dataCadastro) {
		
    	super();
    	
    	DataUtil.validarData(dataCadastro);
		EmailUtil.validarEmail(email);
    	
		this.nome = nome;
		this.usuario = usuario;
		this.email = email;
		this.telefone = telefone;
		this.tipoServidor = tipoServidor;
		this.coordenacao = coordenacao;
		this.unidadeEnsino = "IFPE Campus Garanhuns";
		this.dataCadastro = dataCadastro;
		this.ativo = 1;
	}

        public List<Curso> getEquipeServidores() {
            return equipeServidores;
        }

        public void setEquipeServidores(List<Curso> equipeServidores) {
            this.equipeServidores = equipeServidores;
        }

    
        public List<Curso> getCursosMinistrados() {
            return cursosMinistrados;
        }

        public void setCursosMinistrados(List<Curso> cursosMinistrados) {
            this.cursosMinistrados = cursosMinistrados;
        }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoServidor getTipoServidor() {
		return tipoServidor;
	}

	public void setTipoServidor(TipoServidor tipoServidor) {
		this.tipoServidor = tipoServidor;
	}

	public Coordenacao getCoordenacao() {
		return coordenacao;
	}

	public void setCoordenacao(Coordenacao coordenacao) {
		this.coordenacao = coordenacao;
	}

	public String getUnidadeEnsino() {
		return unidadeEnsino;
	}

	public void setUnidadeEnsino(String unidadeEnsino) {
		this.unidadeEnsino = unidadeEnsino;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return nome;
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
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Servidor other = (Servidor) obj;
		if (codigo != other.getCodigo())
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.getNome()))
			return false;
		return true;
	}
	
	
    
}
