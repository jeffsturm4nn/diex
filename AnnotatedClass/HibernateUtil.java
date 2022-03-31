package model.util;

import model.negocio.Aluno;
import model.negocio.Coordenacao;
import model.negocio.Servidor;
import model.negocio.TipoServidor;
import model.negocio.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static HibernateUtil myself;
	private SessionFactory sessionFactory;
	
    private HibernateUtil() {
    	
	    sessionFactory = new AnnotationConfiguration()
	    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
            .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
            .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/diex")
            .setProperty("hibernate.connection.username", "root")
            .setProperty("hibernate.connection.password", "foreign")
            .setProperty("hibernate.hbm2ddl.auto", "none")
            .setProperty("hibernate.show_sql", "true")
            .setProperty("hibernate.format_sql", "true")
            //.setProperty("hibernate.c3p0.acquire_increment", "1")
            //.setProperty("hibernate.c3p0.idle_test_period", "100")
            //.setProperty("hibernate.c3p0.max_size", "10")
            //.setProperty("hibernate.c3p0.max_statements", "0")
            //.setProperty("hibernate.c3p0.min_size", "5")
            //.setProperty("hibernate.c3p0.timeout", "100")
            .addAnnotatedClass(Usuario.class)
            .addAnnotatedClass(Aluno.class)
            .addAnnotatedClass(Servidor.class)
            .addAnnotatedClass(TipoServidor.class)
            .addAnnotatedClass(Coordenacao.class)
            .buildSessionFactory();
	    
    }
	
	public Session getSession() {
		
        Session toReturn = sessionFactory.openSession();
        toReturn.beginTransaction();
        return toReturn;
		
	}
	
	public static HibernateUtil getInstance() {
		if (myself == null) {
			myself = new HibernateUtil();
		}
		return myself;
	}
	
}
