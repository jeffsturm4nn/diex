package model.negocio;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 *
 * @author Jefferson Sales
 */
@Entity
@Table(name="usuarios", schema="diex")
public class Usuario implements Serializable {
    @Transient
    private static final long serialVersionUID = 7143393803732857714L;
    @Id
    @GeneratedValue
    @Column(name="usu_id", nullable=false)
    private int codigo;
    @Column(name="usu_ativo")
    private int ativo;
    @Column(name="usu_senha", length = 30)
    private String senha;
    @Column(name="usu_siape", length = 20)
    private String siape;

    public Usuario() {
    }

    public Usuario(String siape, String senha) {
	this.siape = siape;
	this.senha = senha;
        this.ativo = 1;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getSiape() {
	return this.siape;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }
 
    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
    
}
