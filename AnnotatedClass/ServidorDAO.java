
package model.DAO;

import java.util.List;
import model.negocio.Servidor;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Fabricio
 */
public class ServidorDAO {
    
    private HibernateUtil instance = HibernateUtil.getInstance();
    
    public void save(Servidor servidor) {
        Session session = instance.getSession();
        try {
            session.save(servidor);
            session.getTransaction().commit();
        }catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        } 
    }
    
    public void update(Servidor servidor) {
        Session session = instance.getSession();
        try {
            session.saveOrUpdate(servidor);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
    
    public Servidor get(int codigo) {
         Session session = instance.getSession();
         Servidor servidor = (Servidor)session.get(Servidor.class, codigo);
         if (servidor != null) {
             session.close();
             return servidor;
         }
         throw new NullPointerException("Servidor não encontrado.");
         
    }
    
    public void remove(int codigo) {
        Session session = instance.getSession();
        try {
            Servidor servidor = (Servidor)session.get(Servidor.class, codigo);
            if (servidor == null) {
                throw new NullPointerException("Servidor não encontrado."); 
            }
            servidor.setAtivo(0);
            session.getTransaction().commit();
        }catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
    
    public List<Servidor> listAll() {
        Session session = instance.getSession();
        try {
            Criteria criteria = session.createCriteria(Servidor.class);
            return criteria.list();
        } finally {
            session.close();
        }
    }
}
