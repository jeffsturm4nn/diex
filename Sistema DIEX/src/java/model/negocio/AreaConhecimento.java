package model.negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

import control.BaseEntity;
@Entity
@Table(name="area_conhecimento", schema="diex")
public class AreaConhecimento implements Serializable, BaseEntity{
    
    @Transient
    private static final long serialVersionUID = -6122988121664596536L;
    
    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private int codigo;
    
    @Column(name="nome", nullable = false, length = 100)
    private String areaConhecimento;

    @Column(name="ativo", nullable=false)
    private int ativo;
    
    @OneToMany(mappedBy = "areaConhecimento"/*, fetch= FetchType.EAGER*/)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Curso> cursos;

    public AreaConhecimento() {
	super();
    }
   
    public AreaConhecimento(String areaConhecimento) {
	super();
	this.areaConhecimento = areaConhecimento;
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

    public String getAreaConhecimento() {
        return this.areaConhecimento;
    }

    public void setAreaConhecimento(String areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }

	@Override
	public Integer getId() {
		return codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((areaConhecimento == null) ? 0 : areaConhecimento.hashCode());
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
		AreaConhecimento other = (AreaConhecimento) obj;
		if (areaConhecimento == null) {
			if (other.areaConhecimento != null)
				return false;
		} else if (!areaConhecimento.equals(other.getAreaConhecimento()))
			return false;
		if (codigo != other.getCodigo())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return areaConhecimento;
	}
	
}
