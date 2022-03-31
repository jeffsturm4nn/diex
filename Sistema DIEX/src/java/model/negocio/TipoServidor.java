package model.negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

import control.BaseEntity;
@Entity
@Table(name="tipo_servidor", schema="diex")
public class TipoServidor implements Serializable, BaseEntity{
	
    @Transient
    private static final long serialVersionUID = 3166841345907920178L;
    
    @Id
    @GeneratedValue
    @Column(name = "id", nullable= false)
    private int codigo;
    
    @Column(name = "nome", nullable = false, length = 50)
    private String tipoServidor;
    
    @OneToMany(mappedBy = "tipoServidor"/*, fetch=FetchType.EAGER*/)
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

	@Override
	public Integer getId() {
		return this.codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result
				+ ((tipoServidor == null) ? 0 : tipoServidor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoServidor))
			return false;
		TipoServidor other = (TipoServidor) obj;
		if (codigo != other.codigo)
			return false;
		if (tipoServidor == null) {
			if (other.tipoServidor != null)
				return false;
		} else if (!tipoServidor.equals(other.getTipoServidor()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return tipoServidor;
	}
	
	

}
