package model.negocio;


import java.io.Serializable;
import javax.persistence.*;
import model.util.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 *
 * @author Jefferson Sales
 */
@Entity
@Table(name="servidor", schema = "diex")
public class Servidor implements Serializable {
    @Transient
    private static final long serialVersionUID = -1608369009651899048L;
    @Id
    @Column(name="ser_id", nullable = false)
    private int codigo;
    @Column(name="ser_ativo")
    private int ativo;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="ser_id", nullable = false, insertable = true, updatable = true)
    private Usuario usuario;
    @Column(name="ser_nome", length = 100)
    private String nome;
    @Column(name="ser_rg", length = 20)
    private String rg;
    @Column(name="ser_cpf", length = 14, nullable = false)
    private String cpf;
    @Column(name="ser_email", length = 100)
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ser_coordenacao", nullable= false, insertable= true, updatable = true)
    private Coordenacao coordenacao;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ser_tipo_servidor", nullable= false, insertable= true, updatable = true)
    private TipoServidor tipoServidor;
    @Column(name="ser_fone", length = 45)
    private String telefone;
    @Column(name="ser_unidade_ensino", length = 100, nullable = false)
    private final String unidadeEnsino = "IFPE Campus Garanhuns";
    @Column(name="ser_data_cadastro", length = 10)
    private String dataCadastro;
    
    public Servidor() {
	super();
    }

    public Servidor(Usuario usuario, String nome, String rg, String cpf,
	    String email, Coordenacao coordenacao) {

	super();

	RgUtil.validarRG(rg);
	CpfUtil.validarCpf(cpf);
	EmailUtil.validarEmail(email);

	this.nome = nome;
	this.rg = rg;
	this.cpf = cpf;
	this.email = email;
	this.coordenacao = coordenacao;
	this.usuario = usuario;
        this.ativo = 1;
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

    public int getCodigo() {
	return codigo;
    }

    public String getNome() {
	return nome;
    }

    public String getRg() {
	return rg;
    }

    public String getCpf() {
	return cpf;
    }
    
    public Coordenacao getCoordenacao() {
	return coordenacao;
    }

    public String getTelefone() {
	return telefone;
    }

    public String getUnidadeEnsino() {
	return unidadeEnsino;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public TipoServidor getTipoServidor() {
	return tipoServidor;
    }

    public void setTipoServidor(TipoServidor tipoServidor) {
	this.tipoServidor = tipoServidor;
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

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCoordenacao(Coordenacao coordenacao) {
        this.coordenacao = coordenacao;
    }

}
