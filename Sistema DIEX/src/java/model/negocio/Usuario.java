package model.negocio;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 *
 * @author Jefferson Sales
 */
@Entity
@Table(name="usuario", schema="diex")
public class Usuario implements Serializable {
	
    @Transient
    private static final long serialVersionUID = 7143393803732857714L;
    
    @Id
    @GeneratedValue
    @Column(name="id", nullable=false)
    private int codigo;
    
    @Column(name="siape", nullable=false, length = 50)
    private String siape;

    @Column(name="senha", nullable=false, length = 50)
    private String senha;
    
    @Column(name="ativo", nullable=false)
    private int ativo;
    
    public Usuario() {
    	super();
    }

    public Usuario(String siape, String senha) {
        super();
    	this.siape = siape;
    	this.senha = senha;
        this.ativo = 1;
    }

    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }

    public String getSiape() {
	return siape;
    }

    public void setSiape(String siape) {
	this.siape = siape;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
 	this.senha = senha;
    }

    public int getAtivo() {
	return ativo;
    }

    public void setAtivo(int ativo) {
	this.ativo = ativo;
    }
    
}
