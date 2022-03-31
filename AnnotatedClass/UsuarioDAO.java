
package model.DAO;

import model.negocio.Usuario;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Fabricio
 */
public class UsuarioDAO {
 
    private HibernateUtil instance = HibernateUtil.getInstance();
    
    public void save(Usuario usuario) {
        Session session = instance.getSession();
        try {
            session.save(usuario);
            session.getTransaction().commit();
        } catch(HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        } 
    }
    
    public void update(Usuario usuario) {
        Session session = instance.getSession();
        try {
            session.saveOrUpdate(usuario);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    } 
 
    public void remove(int codigo) {
        Session session = instance.getSession();
        try {
            Usuario usuario = (Usuario)session.get(Usuario.class, codigo);
            usuario.setAtivo(0);
            session.getTransaction().commit();
        } catch(HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
