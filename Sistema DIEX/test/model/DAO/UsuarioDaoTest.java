/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.Usuario;
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
public class UsuarioDaoTest {
    
    public UsuarioDaoTest() {
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
     * Test of adicionar method, of class UsuarioDao.
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        Usuario usuario = new Usuario("12345", "2013");
        UsuarioDao instance = new UsuarioDao();
        int expResult = 11;
        int result = instance.adicionar(usuario);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of alterar method, of class UsuarioDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        
        UsuarioDao instance = new UsuarioDao();
        Usuario usuario = instance.retrieveById(6);
        usuario.setSenha("55555");
        
        boolean result = instance.alterar(usuario);
        assertTrue(result);
        
    }

    /**
     * Test of remover method, of class UsuarioDao.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        int codigo = 3;
        
        UsuarioDao instance = new UsuarioDao();
        
        boolean result = instance.remover(codigo);
        assertTrue(result);
        
    }

}
