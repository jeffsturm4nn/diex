/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.negocio;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Administrador-Pc
 */
@Entity
@Table(name="solicitacao_edicao", schema="diex")
public class SolicitacaoEdicao implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="id", nullable=false)
    private int codigo;
    
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="id_curso", nullable=false, insertable=true, updatable=true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Curso codigoCurso;
    
    @Column(name="solicitacao_nome", length = 1000, nullable=false)
    private String nomeSolicitacao;
    
    public SolicitacaoEdicao() {
        super();
        this.codigoCurso = new Curso();
    }
    
    public SolicitacaoEdicao(String nomeSolicitacao) {
        super();
        this.nomeSolicitacao = nomeSolicitacao;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Curso getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Curso codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNomeSolicitacao() {
        return nomeSolicitacao;
    }

    public void setNomeSolicitacao(String nomeSolicitacao) {
        this.nomeSolicitacao = nomeSolicitacao;
    }
    
}
