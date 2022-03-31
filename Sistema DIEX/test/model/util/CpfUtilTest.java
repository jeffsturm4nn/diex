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
public class CpfUtilTest {
    
    public CpfUtilTest() {
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
     * Test of validarCpf method, of class CpfUtil.
     */
    @Test(expected = NullPointerException.class)
    public void testValidarCpf1() {
        System.out.println("validarCpf");
        String cpf = null;
        CpfUtil.validarCpf(cpf);
        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testValidarCpf2() {
        System.out.println("validarCpf");
        String cpf = "1234.567.67876-45";
        CpfUtil.validarCpf(cpf);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testValidarCpf3() {
        System.out.println("validarCpf");
        String cpf = "000.000.000.0x";
        CpfUtil.validarCpf(cpf);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testValidarCpf4() {
        System.out.println("validarCpf");
        String cpf = "000.000.000-01";
        CpfUtil.validarCpf(cpf);
    }
    
    @Test
    public void testValidarCpf() {
        System.out.println("validarCpf");
        String cpf = "097.644.744-46";
        CpfUtil.validarCpf(cpf);
    }
}