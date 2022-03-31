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
public class HoraUtilTest {
    
    public HoraUtilTest() {
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
     * Test of validarHora method, of class HoraUtil.
     */
    
    @Test(expected=IllegalArgumentException.class)
    public void testValidarHora1() {
        System.out.println("validarHora");
        int horas = 24;
        int minutos = 20;
        int segundos = 30;
        HoraUtil.validarHora(horas, minutos, segundos);
        
    }
    
    @Test
    public void testValidarHora() {
        System.out.println("validarHora");
        int horas = 16;
        int minutos = 53;
        int segundos = 40;
        HoraUtil.validarHora(horas, minutos, segundos);
    }

    /**
     * Test of validarHora method, of class HoraUtil.
     */
    
    @Test(expected=NullPointerException.class)
    public void testValidarHora_String1() {
        System.out.println("validarHora");
        String hora = null;
        HoraUtil.validarHora(hora);
        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testValidarHora_String2() {
        System.out.println("validarHora");
        String hora = "99:99:99";
        HoraUtil.validarHora(hora);
    }
    
    @Test
    public void testValidarHora_String3() {
        System.out.println("validarHora");
        String hora = "13:20:20";
        HoraUtil.validarHora(hora);
    }
}