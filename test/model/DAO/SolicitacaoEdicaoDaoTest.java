/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.Curso;
import model.negocio.SolicitacaoEdicao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador-Pc
 */
public class SolicitacaoEdicaoDaoTest {
    
    public SolicitacaoEdicaoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of adicionar method, of class SolicitacaoEdicaoDao.
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        
        SolicitacaoEdicao solicitacao = new SolicitacaoEdicao("editar");
        SolicitacaoEdicaoDao instance = new SolicitacaoEdicaoDao();
        
        CursoDao cursoDao = new CursoDao();
        Curso curso = cursoDao.recuperarPorId(1);
        solicitacao.setCodigoCurso(curso);
        
        int expResult = 6;
        int result = instance.adicionar(solicitacao);
        assertEquals(expResult, result);
        
    }


    

    /**
     * Test of recuperarTodos method, of class SolicitacaoEdicaoDao.
     */
    @Test
    public void testRecuperarTodos() throws Exception {
        System.out.println("recuperarTodos");
        SolicitacaoEdicaoDao instance = new SolicitacaoEdicaoDao();
        int expectedLength = 5;
        List<SolicitacaoEdicao> result = instance.recuperarTodos();
        assertEquals(expectedLength, result.size());
        
    }
}