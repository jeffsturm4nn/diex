/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

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
public class TelefoneUtilTest {
    
    public TelefoneUtilTest() {
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
     * Test of validarTelefone method, of class TelefoneUtil.
     */
    @Test(expected=NullPointerException.class)
    public void testValidarTelefone1() {
        System.out.println("validarTelefone");
        String telefone = null;
        TelefoneUtil.validarTelefone(telefone);
        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testValidarTelefone2() {
        System.out.println("validarTelefone");
        String telefone = "(67)12345-378890";
        TelefoneUtil.validarTelefone(telefone);
    }
    
    @Test
    public void testValidarTelefone3() {
        System.out.println("validarTelefone");
        String telefone = "(87)9656-1229";
        TelefoneUtil.validarTelefone(telefone);
    }
}