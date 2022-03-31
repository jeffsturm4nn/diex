package model.negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

import control.BaseEntity;

@Entity
@Table(name = "coordenacao", schema = "diex")
public class Coordenacao implements Serializable, BaseEntity{
	
    @Transient
    private static final long serialVersionUID = 5156944712448172700L;
    
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int codigo;
    
    @Column(name = "nome", nullable = false, length = 100)
    private String coordenacao;
    
    @Column(name = "ativo", nullable = false)
    private int ativo;
    
    @OneToMany(mappedBy = "coordenacao"/*, fetch=FetchType.EAGER*/)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Servidor> servidores;

    public Coordenacao() {
    	super();
    }

    public Coordenacao(String coordenacao) {
    	super();
    	this.coordenacao = coordenacao;
    	this.ativo = 1;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
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

    public String getCoordenacao() {
        return this.coordenacao;
    }

    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
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
		+ ((coordenacao == null) ? 0 : coordenacao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Coordenacao))
		return false;
	Coordenacao other = (Coordenacao) obj;
	if (codigo != other.getCodigo())
		return false;
	if (coordenacao == null) {
		if (other.coordenacao != null)
			return false;
	} else if (!coordenacao.equals(other.getCoordenacao()))
		return false;
	return true;
    }

	@Override
	public String toString() {
		return coordenacao;
	}

}
