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
public class EmailUtilTest {
    
    public EmailUtilTest() {
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
     * Test of validarEmail method, of class EmailUtil.
     */
    @Test(expected = NullPointerException.class)
    public void testValidarEmail1() {
        System.out.println("validarEmail");
        String email = null;
        EmailUtil.validarEmail(email);
        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testValidarEmail2() {
        System.out.println("validarEmail");
        String email = "123@d.7";
        EmailUtil.validarEmail(email);
    }
    
    @Test
    public void testValidarEmail3() {
        System.out.println("validarEmail");
        String email = "fabricio_12.f@hotmail.com";
        EmailUtil.validarEmail(email);
    }
}