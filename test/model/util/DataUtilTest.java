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
public class DataUtilTest {
    
    public DataUtilTest() {
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
     * Test of validarData method, of class DataUtil.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testValidarDataError() {
        System.out.println("validarData");
        int dia = 32;
        int mes = 12;
        int ano = 2013;
        DataUtil.validarData(dia, mes, ano);
        
    }
    
    @Test
    public void testValidarData() {
        System.out.println("validarDara");
        int dia = 01;
        int mes = 11;
        int ano = 2012;
        DataUtil.validarData(dia,mes,ano);
    }

    /**
     * Test of validarData method, of class DataUtil.
     */
    @Test(expected=NullPointerException.class)
    public void testValidarData_String1() {
        System.out.println("validarData");
        String data = null;
        DataUtil.validarData(data);
        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testValidarData_String2() {
        System.out.println("validarData");
        String data = "01-11-1994";
        DataUtil.validarData(data);
    }
    
    @Test
    public void testValidarData_String() {
        System.out.println("validarData");
        String data = "01/11/1994";
        DataUtil.validarData(data);
    }

    /**
     * Test of dataAtual method, of class DataUtil.
     */
    @Test
    public void testDataAtual() {
        System.out.println("VerificarDataAtual");
        String expResult = "10/7/2013";
        String result = DataUtil.dataAtual();
        assertEquals(expResult, result);
        
    }
}