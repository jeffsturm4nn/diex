/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.ConteudoProgramatico;
import model.negocio.Curso;
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
public class ConteudoProgramaticoDaoTest {
    
    public ConteudoProgramaticoDaoTest() {
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
     * Test of adicionar method, of class ConteudoProgramaticoDao.
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        ConteudoProgramatico conteudo = new ConteudoProgramatico("31/12/2012", "conteudo");
        ConteudoProgramaticoDao instance = new ConteudoProgramaticoDao();
        CursoDao cursoDao = new CursoDao();
        Curso curso = cursoDao.recuperarPorId(1);
        conteudo.setCodigoCurso(curso);
        int expResult = 21;
        int result = instance.adicionar(conteudo);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        
        ConteudoProgramaticoDao instance = new ConteudoProgramaticoDao();
        boolean result = instance.remover(11);
        
        assertTrue(result);
    }

    /**
     * Test of alterar method, of class ConteudoProgramaticoDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        ConteudoProgramaticoDao instance = new ConteudoProgramaticoDao();
        List conteudos = instance.recuperarTodos();
        ConteudoProgramatico conteudo = (ConteudoProgramatico)conteudos.get(0);
        conteudo.setConteudo("TESTE");
        boolean expResult = true;
        boolean result = instance.alterar(conteudo);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of recuperarTodos method, of class ConteudoProgramaticoDao.
     */
    @Test
    public void testRecuperarTodos() throws Exception {
        System.out.println("recuperarTodos");
        ConteudoProgramaticoDao instance = new ConteudoProgramaticoDao();
        int expLength = 14;
        List result = instance.recuperarTodos();
        assertEquals(expLength, result.size());
        
    }
}