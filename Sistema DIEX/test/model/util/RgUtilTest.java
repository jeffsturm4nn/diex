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
public class RgUtilTest {
    
    public RgUtilTest() {
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
     * Test of validarRG method, of class RgUtil.
     */
    @Test(expected=NullPointerException.class)
    public void testValidarRG1() {
        System.out.println("validarRG");
        String rg = null;
        RgUtil.validarRG(rg);
        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testValidarRG2() {
        System.out.println("validarRG");
        String rg = "12.233.455";
        RgUtil.validarRG(rg);
    }
    
    @Test
    public void testValidarRG3() {
        System.out.println("validarRG");
        String rg = "1.234.567";
        RgUtil.validarRG(rg);
    }
}