package model.negocio;

import java.io.Serializable;

import javax.persistence.*;

import control.BaseEntity;

@Entity
@Table(name = "escolaridade", schema = "diex")
public class Escolaridade implements Serializable, BaseEntity{

   @Transient
    private static final long serialVersionUID = -3174111062391699448L;

   @Id
   @GeneratedValue
   @Column(name = "id", nullable = false)
   private int codigo;
	
   @Column(name = "nome", nullable = false, length = 100)
   private String escolaridade;

    public Escolaridade() {
	super();
    }

    public Escolaridade(String escolaridade) {
	super();
	this.escolaridade = escolaridade;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEscolaridade() {
        return this.escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
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
				+ ((escolaridade == null) ? 0 : escolaridade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Escolaridade))
			return false;
		Escolaridade other = (Escolaridade) obj;
		if (codigo != other.codigo)
			return false;
		if (escolaridade == null) {
			if (other.escolaridade != null)
				return false;
		} else if (!escolaridade.equals(other.getEscolaridade()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return escolaridade;
	}
	
	

}
