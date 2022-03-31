/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.Estado;
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
public class EstadoDaoTest {
    
    public EstadoDaoTest() {
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
     * Test of recuperarTodos method, of class EstadoDao.
     */
    @Test
    public void testRecuperarTodos() throws Exception {
        System.out.println("recuperarTodos");
        EstadoDao instance = new EstadoDao();
        
        int expectedLength = 26;
        List<Estado> result = instance.recuperarTodos();
        assertEquals(expectedLength, result.size());
        
    }
}