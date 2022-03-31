package model.negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

import control.BaseEntity;

@Entity
@Table(name="local_realizacao", schema="diex")
public class LocalRealizacao implements Serializable, BaseEntity{
    
    @Transient
    private static final long serialVersionUID = -8200192250805149236L;

    @Id
    @GeneratedValue
    @Column(name="id", nullable=false)
    private int codigo;
    
    @Column(name="nome", nullable=false, length=200)
    private String localRealizacao;
    
    @Column(name="ativo", nullable=false)
    private int ativo;
    
    @OneToMany(mappedBy = "localRealizacao"/*, fetch= FetchType.EAGER*/)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Curso> cursos;
    
    public LocalRealizacao() {
	super();
    }

    public LocalRealizacao(String localRealizacao) {
	super();
	this.localRealizacao = localRealizacao;
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

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLocalRealizacao() {
        return this.localRealizacao;
    }

    public void setLocalRealizacao(String localRealizacao) {
        this.localRealizacao = localRealizacao;
    }

	@Override
	public Integer getId() {
		return codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result
				+ ((localRealizacao == null) ? 0 : localRealizacao.hashCode());
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
		LocalRealizacao other = (LocalRealizacao) obj;
		if (codigo != other.getCodigo())
			return false;
		if (localRealizacao == null) {
			if (other.localRealizacao != null)
				return false;
		} else if (!localRealizacao.equals(other.getLocalRealizacao()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return localRealizacao;
	}
	
	

}
