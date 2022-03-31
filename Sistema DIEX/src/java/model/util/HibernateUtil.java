package model.util;

import model.negocio.Aluno;
import model.negocio.AreaConhecimento;
import model.negocio.AreaTematica;
import model.negocio.ConteudoProgramatico;
import model.negocio.Coordenacao;
import model.negocio.Curso;
import model.negocio.Endereco;
import model.negocio.Escolaridade;
import model.negocio.Estado;
import model.negocio.LinhaExtensao;
import model.negocio.LocalRealizacao;
import model.negocio.PerfilCandidato;
import model.negocio.Servidor;
import model.negocio.SolicitacaoEdicao;
import model.negocio.TipoServidor;
import model.negocio.Usuario;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static HibernateUtil myself;
    private static SessionFactory sessionFactory;
	
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
        .addAnnotatedClass(Aluno.class)
        .addAnnotatedClass(AreaConhecimento.class)
        .addAnnotatedClass(AreaTematica.class)
        .addAnnotatedClass(ConteudoProgramatico.class)
        .addAnnotatedClass(Coordenacao.class)
        .addAnnotatedClass(Curso.class)
        .addAnnotatedClass(Endereco.class)
        .addAnnotatedClass(Escolaridade.class)
        .addAnnotatedClass(Estado.class)
        .addAnnotatedClass(LinhaExtensao.class)
        .addAnnotatedClass(LocalRealizacao.class)
        .addAnnotatedClass(PerfilCandidato.class)
        .addAnnotatedClass(Servidor.class)
        .addAnnotatedClass(SolicitacaoEdicao.class)
        .addAnnotatedClass(TipoServidor.class)
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();
	    
    }
	
    public static Session getSession() {

        Session sessionOpen = sessionFactory.openSession();
        return sessionOpen;

    }

    public static HibernateUtil getInstance() {

        if (myself == null) {

            myself = new HibernateUtil();

        }

        return myself;

    }
	
}
