package model.negocio;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

/**
 *
 *
 * @author Jefferson Sales
 */
@Entity
@Table(name = "endereco", schema = "diex")
public class Endereco implements Serializable {

    @Transient
    private static final long serialVersionUID = 4869088040650717169L;
	
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int codigo;
    
    @Column(name = "logradouro", nullable = false, length = 150)
    private String logradouro;
    
    @Column(name = "numero", length = 10)
    private String numero;
    
    @Column(name = "bairro", nullable = false, length = 60)
    private String bairro;
    
    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;
    
    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado", nullable = false, insertable = true, updatable = true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Estado estado;
    
    @Column(name = "cep", length = 20)
    private String cep;
    
    public Endereco() {
    	super();
    	this.estado = new Estado();
    }
    
    public Endereco(String logradouro, String numero, String bairro,
	    String cidade, Estado estado, String cep) {
        
                super();

		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
    }
    
    public String getLogradouro() {
    	return this.logradouro;
    }
    
    public void setLogradouro(String logradouro) {
    	this.logradouro = logradouro;
    }
    
    public String getNumero() {
    	return this.numero;
    }
    
    public void setNumero(String numero) {
    	this.numero = numero;
    }
    
    public String getCep() {
    	return this.cep;
    }
    
    public void setCep(String cep) {
    	this.cep = cep;
    }
    
    public String getBairro() {
    	return this.bairro;
    }
    
    public void setBairro(String bairro) {
    	this.bairro = bairro;
    }
    
    public Estado getEstado() {
    	return this.estado;
    }
    
    public void setEstado(Estado estado) {
    	this.estado = estado;
    }
    
    public String getCidade() {
    	return this.cidade;
    }
    
    public void setCidade(String cidade) {
    	this.cidade = cidade;
    }
    
    public int getCodigo() {
    	return codigo;
    }
    
    public void setCodigo(int codigo) {
    	this.codigo = codigo;
    }
    
}
