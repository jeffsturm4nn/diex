package control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.negocio.Usuario;

/**
 *
 * @author Fabricio Paes, Jefferson Sales, Alexandre Jorge
 */

@ManagedBean
@RequestScoped
public class ControleUsuario {
	
	private Usuario usuario;

	public ControleUsuario() {

    }

    public boolean adicionar(Usuario usuario) {
        return true;
    }

    public void alterar(Usuario usuario) {

    }

    public Usuario recuperar(int codigo) {
        return null;
    }

    public boolean remover(int codigo) {
        return true;
    }
    
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
