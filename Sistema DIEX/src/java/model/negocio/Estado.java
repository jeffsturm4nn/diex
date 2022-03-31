package model.negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;


import control.BaseEntity;

@Entity
@Table(name = "estado", schema = "diex")
public class Estado implements Serializable, BaseEntity{

    @Transient
    private static final long serialVersionUID = 6104353922410225039L;

    @Id
    @Column(name = "id", nullable = false)
    private int codigo;
    
    @Column(name = "estado", nullable = false, length = 2)
    private String estado;

    @OneToMany(mappedBy = "estado"/*, fetch = FetchType.EAGER*/)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Endereco> enderecos;
    
    public Estado() {
    	super();
    }

    public Estado(int codigo, String estado) {
        super();
        this.codigo = codigo;
        this.estado = estado;
    }
    
    public List<Endereco> getEnderecos() {
  	return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
	this.enderecos = enderecos;
    }

    public int getCodigo() {
        return this.codigo;
    }
    
    public String getEstado() {
        return this.estado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		Estado other = (Estado) obj;
		if (codigo != other.getCodigo())
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.getEstado()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return estado;
	}
	
	

}
