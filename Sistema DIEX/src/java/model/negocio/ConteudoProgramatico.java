package model.negocio;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="conteudo_programatico", schema ="diex")
public class ConteudoProgramatico implements Serializable {
    
	
   @Transient
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   @Column(name="id", nullable=false)
   private int codigoConteudo;
    
   @ManyToOne//(fetch=FetchType.EAGER)
   @LazyCollection(LazyCollectionOption.FALSE)
   @JoinColumn(name="id_curso", nullable= false, insertable= true, updatable = true)
   @Fetch(org.hibernate.annotations.FetchMode.JOIN)
   @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
   private Curso codigoCurso;
        
   @Column(name="data_prevista", nullable=false, length = 10)
   private String dataProgramada;
        
   @Column(name="nome", nullable=false, length=200)
   private String conteudo;
        
   public ConteudoProgramatico(String dataProgramada, String conteudo) {
        super();
        this.dataProgramada = dataProgramada;
        this.conteudo=conteudo;
    }

   public ConteudoProgramatico() {
        super();
	codigoCurso = new Curso();
   }

   public void setCodigoCurso(Curso codigoCurso) {
        this.codigoCurso = codigoCurso;
   }
    
   public Curso getCodigoCurso() {
        return codigoCurso;
   }

   public String getDataProgramada() {
	return dataProgramada;
   }
        
   public void setDataProgramada(String dataProgramada) {
	this.dataProgramada = dataProgramada;
   }
        
   public String getConteudo() {
	return conteudo;
   }
        
   public void setConteudo(String conteudo) {
	this.conteudo = conteudo;
   }

public int getCodigoConteudo() {
	return codigoConteudo;
}

public void setCodigoConteudo(int codigoConteudo) {
	this.codigoConteudo = codigoConteudo;
}

}
