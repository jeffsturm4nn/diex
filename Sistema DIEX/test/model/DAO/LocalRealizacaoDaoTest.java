/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.LocalRealizacao;
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
public class LocalRealizacaoDaoTest {
    
    public LocalRealizacaoDaoTest() {
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
     * Test of recuperarTodos method, of class LocalRealizacaoDao.
     */
    @Test
    public void testRecuperarTodos() throws Exception {
        System.out.println("recuperarTodos");
        LocalRealizacaoDao instance = new LocalRealizacaoDao();
        int expectedLength = 5;
        List<LocalRealizacao> result = instance.recuperarTodos();
        assertEquals(expectedLength, result.size());
        
    }
}