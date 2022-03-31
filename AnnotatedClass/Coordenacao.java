package model.negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name= "coordenacao", schema = "diex")
public class Coordenacao implements Serializable{
    @Transient
    private static final long serialVersionUID = 5156944712448172700L;
    @Id
    @GeneratedValue
    @Column(name = "coo_id", nullable = false)
    private int codigo;
    @Column(name = "coo_nome", length = 100)
    private String coordenacao;
    @OneToMany(mappedBy="coordenacao", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Servidor> servidores;

    public Coordenacao() {
	super();
    }

    public Coordenacao(String coordenacao) {
	super();
	this.coordenacao = coordenacao;
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

}
