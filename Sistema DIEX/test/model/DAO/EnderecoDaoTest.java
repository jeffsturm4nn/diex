/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.Endereco;
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
public class EnderecoDaoTest {
    
    public EnderecoDaoTest() {
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
     * Test of adicionar method, of class EnderecoDao.
     */
    
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        EstadoDao estadoDao = new EstadoDao();
        List estados = estadoDao.recuperarTodos();
        Estado estado = (Estado)estados.get(0);
        
        Endereco objeto = new Endereco("Rua 7 de Setembro", "92", "Centro", "Garanhuns", estado, "55290-000");
        EnderecoDao instance = new EnderecoDao();
        int expResult = 34;
        int result = instance.adicionar(objeto);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of alterar method, of class EnderecoDao.
     */
    
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        
        EnderecoDao instance = new EnderecoDao();
        Endereco endereco = instance.recuperarPorId(2);
        endereco.setLogradouro("Rua Olavo");
        
        boolean result = instance.alterar(endereco);
        assertTrue(result);
        
    }

    /**
     * Test of recuperarPorId method, of class EnderecoDao.
     */
    
    @Test
    public void testRecuperarPorId() throws Exception {
        System.out.println("recuperarPorId");
        int codigoEsperado = 1;
        
        EnderecoDao instance = new EnderecoDao();
        Endereco enderecoRecuperado = instance.recuperarPorId(codigoEsperado);
        
        int codigoRecuperado = enderecoRecuperado.getCodigo();
        assertEquals(codigoEsperado, codigoRecuperado);
        
    }

    /**
     * Test of recuperarTodos method, of class EnderecoDao.
     */
    @Test
    public void testRecuperarTodos() throws Exception {
        System.out.println("recuperarTodos");
        EnderecoDao instance = new EnderecoDao();
        int expectedLength = 32;
        List result = instance.recuperarTodos();
        assertEquals(expectedLength, result.size());
        
    }
}