package model.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author LUAN
 */
public class GenericDao<T extends Serializable> {
    
    private final Class<T> persistentClass;

    /*
     * Construtor padrão, sem parâmetros, é vital
     * para instanciar a persistentClass.
     */
    public GenericDao() {

        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        
    }

    /**
     * Método que recebe como parâmetro um objeto genérico 
     * e salva um novo registro no banco de dados.
     * 
     * @param entity
     * @return int
     */
    protected int save(T entity) throws Exception {
        
        Session session = createSession();
    	int codigo = -1;
    	
    	try {
            
            session.getTransaction().begin();
            codigo = (Integer)session.save(entity);
            session.getTransaction().commit();
            
        } catch (HibernateException exception) {
            
            session.getTransaction().rollback();
            throw exception;
            
        } finally {
            
            session.close();
            
        }
    	
    	return codigo;
        
    }

    /**
     * Método que recebe como parâmetro um objeto genérico 
     * e altera o mesmo registro no banco de dados.
     * 
     * @param entity
     * @return boolean
     */
    protected boolean update(T entity) throws Exception {
        
        Session session = createSession();
    	boolean completed = false;
    	
    	try {
    		
            session.getTransaction().begin();
            session.update(entity);
            session.getTransaction().commit();
            
            completed =  true;
            
        } catch (HibernateException exception) {
            
            session.getTransaction().rollback();
            throw exception;
            
        } finally {
        	
            session.close();
            
        }
    	
    	return completed;
        
    }

    protected void delete(T entity) throws Exception {
        
        Session session = createSession();
    	
    	try {
    		
            session.getTransaction().begin();
            session.delete(entity);
            session.getTransaction().commit();
            
        } catch (HibernateException exception) {
            
            session.getTransaction().rollback();
            throw exception;
            
        } finally {
        	
            session.close();
            
        }
        
    }
    
    /**
     * Método para recuperar e retornar um objeto da classe 
     * genérico com base no id passado como parâmetro.
     * 
     * @param id
     * @return T
     */
    protected T retrieveById(int id) throws Exception {
    	
        Session session = createSession();
    	T instance = null;
    	
    	try {
            
            instance = (T) session.get(persistentClass, id);
    	
        } finally {
    		
            session.close();
    		
    	}
    	
        return instance;
    	
    }
    
    /**
     * Método para recuperar e retornar um objeto ativo da 
     * classe genérico com base no id passado como parâmetro.
     * 
     * @param id
     * @return T
     */
    protected T retrieveByIdAndActive(int id) throws Exception {
    	
        Session session = createSession();
    	T instance = null;
        
    	try {
            
            instance = (T) session.createCriteria(persistentClass)
                    .add(Restrictions.idEq(id))
                    .add(Restrictions.eq("ativo", 1))
                    .uniqueResult();
    	
        } finally {
    		
            session.close();
    		
    	}
    	
        return instance;
    	
    }
    
/**
     * Método para recuperar e retornar todos os objetos 
     * da classe genérico persistidos no banco de dados.
     * 
     * @return List<T>
     */
    protected List<T> retrieveAll() throws Exception {
        
        Session session = createSession();
    	List<T> list = null;
    	
    	try {
    		
            list = session.createCriteria(persistentClass)
                    .addOrder(Order.asc("id"))
                    .list();
                    
    		
    	} finally {
    		
            session.close();
    		
    	}
    	
    	return list;
    	
    }
    
    /**
     * Método para recuperar e retornar todos os objetos ativos
     * da classe genérico persistidos no banco de dados.
     * 
     * @return List<T>
     */
    protected List<T> retrieveAllActive() throws Exception {
        
        Session session = createSession();
    	List<T> list = null;
    	
    	try {
    		
            list = session.createCriteria(persistentClass)
                    .add(Restrictions.eq("ativo", 1))
                    .addOrder(Order.asc("id"))
                    .list();
    		
    	} finally {
    		
            session.close();
    		
    	}
    	
    	return list;
    	
    }

    /**
     * Método para abrir a session.
     * 
     * @return Session
     */
    protected Session createSession() {
    	
        return HibernateUtil.getInstance().getSession();
        
    }
    
}
