
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.negocio.Servidor;

/**
 *
 * @author Jeff Sturmann
 */

@ManagedBean
@ApplicationScoped
public class Login {
    
    private Servidor servidor;
    private Servidor servidorLogado;
    
    public Login(){
        servidor=null;
        servidorLogado=null;
    }

    public boolean estaLogado(){
        return (servidorLogado != null);
    }
    
    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Servidor getServidorLogado() {
        return servidorLogado;
    }

    public void setServidorLogado(Servidor servidorLogado) {
        this.servidorLogado = servidorLogado;
    }
    
}
