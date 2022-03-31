package model.negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

import control.BaseEntity;

@Entity
@Table(name="area_tematica", schema="diex")
public class AreaTematica implements Serializable, BaseEntity {
    
    @Transient
    private static final long serialVersionUID = 8438699324291205075L;

    @Id
    @GeneratedValue
    @Column(name="id", nullable=false)
    private int codigo;
    
    @Column(name="nome", nullable=false)
    private String areaTematica;
    
    @Column(name="ativo", nullable=false)
    private int ativo;
    
    @OneToMany(mappedBy = "areaTematica"/*, fetch= FetchType.EAGER*/)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Curso> cursos;

    public AreaTematica() {
	super();
    }

    public AreaTematica(String areaTematica) {
	super();
	this.areaTematica = areaTematica;
        this.ativo = 1;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAreaTematica() {
        return this.areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }

	@Override
	public Integer getId() {
		return codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((areaTematica == null) ? 0 : areaTematica.hashCode());
		result = prime * result + codigo;
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
		AreaTematica other = (AreaTematica) obj;
		if (areaTematica == null) {
			if (other.areaTematica != null)
				return false;
		} else if (!areaTematica.equals(other.getAreaTematica()))
			return false;
		if (codigo != other.getCodigo())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return areaTematica;
	}

	
}
