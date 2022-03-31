package model.negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
@Entity
@Table(name="tipo_servidor", schema="diex")
public class TipoServidor implements Serializable{
    @Transient
    private static final long serialVersionUID = 3166841345907920178L;
    @Id
    @GeneratedValue
    @Column(name="tip_id", nullable= false)
    private int codigo;
    @Column(name="tip_servidor", length = 45)
    private String tipoServidor;
    @OneToMany(mappedBy="tipoServidor", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Servidor> servidores;

    public TipoServidor() {
	super();
    }

    public TipoServidor(String tipoServidor) {
	super();
	this.tipoServidor = tipoServidor;
    }
    
    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoServidor() {
        return this.tipoServidor;
    }

    public void setTipoServidor(String tipoServidor) {
        this.tipoServidor = tipoServidor;
    }

}
