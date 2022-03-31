package model.negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

import control.BaseEntity;

@Entity
@Table(name="linha_extensao", schema="diex")
public class LinhaExtensao implements Serializable, BaseEntity{
    
    @Transient
    private static final long serialVersionUID = 761683575963487183L;

    @Id
    @GeneratedValue
    @Column(name="id", nullable=false)
    private int codigo;
    
    @Column(name="nome", nullable=false, length= 100)
    private String linhaExtensao;
    
    @Column(name="ativo", nullable=false)
    private int ativo;
    
    @OneToMany(mappedBy = "linhaExtensao"/*, fetch= FetchType.EAGER*/)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Curso> cursos;
    
    public LinhaExtensao() {
	super();
    }

    public LinhaExtensao(String linhaExtensao) {
	super();
	this.ativo = 1;
	this.linhaExtensao = linhaExtensao;
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

    public String getLinhaExtensao() {
        return this.linhaExtensao;
    }

    public void setLinhaExtensao(String linhaExtensao) {
        this.linhaExtensao = linhaExtensao;
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
				+ ((linhaExtensao == null) ? 0 : linhaExtensao.hashCode());
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
		LinhaExtensao other = (LinhaExtensao) obj;
		if (codigo != other.getCodigo())
			return false;
		if (linhaExtensao == null) {
			if (other.linhaExtensao != null)
				return false;
		} else if (!linhaExtensao.equals(other.getLinhaExtensao()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return linhaExtensao;
	}
}
