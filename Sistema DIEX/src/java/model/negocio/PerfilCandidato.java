package model.negocio;

import java.io.Serializable;

import javax.persistence.*;

import control.BaseEntity;

@Entity
@Table(name = "perfil_aluno", schema = "diex")
public class PerfilCandidato implements Serializable, BaseEntity{

    @Transient
    private static final long serialVersionUID = 6742870899321117849L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int codigo;
    
    @Column(name = "nome", nullable = false, length = 100)
    private String perfilCandidato;

    public PerfilCandidato() {
    	super();
    }
    
    public PerfilCandidato(String perfilCandidato) {
    	super();
    	this.perfilCandidato = perfilCandidato;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPerfilCandidato() {
        return this.perfilCandidato;
    }

    public void setPerfilCandidato(String perfilCandidato) {
        this.perfilCandidato = perfilCandidato;
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
				+ ((perfilCandidato == null) ? 0 : perfilCandidato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PerfilCandidato))
			return false;
		PerfilCandidato other = (PerfilCandidato) obj;
		if (codigo != other.codigo)
			return false;
		if (perfilCandidato == null) {
			if (other.perfilCandidato != null)
				return false;
		} else if (!perfilCandidato.equals(other.getPerfilCandidato()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return perfilCandidato;
	}
	
	

}
