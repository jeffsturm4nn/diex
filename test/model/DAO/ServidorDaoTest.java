/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.Coordenacao;
import model.negocio.Servidor;
import model.negocio.TipoServidor;
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
public class ServidorDaoTest {
    
    public ServidorDaoTest() {
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
     * Test of adicionar method, of class ServidorDao.
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        Usuario usuario = new Usuario("1111", "000");
        TipoServidorDao tipoSD = new TipoServidorDao();
        List<TipoServidor> tipoServidores = tipoSD.recuperarTodos();
        TipoServidor tipo = tipoServidores.get(0);
        
        CoordenacaoDao coordDao = new CoordenacaoDao();
        List<Coordenacao> coords = coordDao.recuperarTodos();
        Coordenacao coord = coords.get(0);
        
        Servidor servidor = new Servidor("Leonardo", usuario, "leo@nardo.com", "(87)1111-1111", tipo, coord, "06/07/2013");
        ServidorDao instance = new ServidorDao();
        int expResult = 8;
        int result = instance.adicionar(servidor);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of alterar method, of class ServidorDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        
        ServidorDao instance = new ServidorDao();
        Servidor servidor = instance.recuperarPorId(2);
        servidor.setUnidadeEnsino("IFPE");
        
        boolean result = instance.alterar(servidor);
        assertTrue(result);
        
    }

    /**
     * Test of remover method, of class ServidorDao.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        int codigo = 2;
        ServidorDao instance = new ServidorDao();
        boolean result = instance.remover(codigo);
        assertTrue(result);
        
    }

    /**
     * Test of recuperarPorId method, of class ServidorDao.
     */
    @Test
    public void testRecuperarPorId() throws Exception {
        System.out.println("recuperarPorId");
        int expectedCode = 3;
        ServidorDao instance = new ServidorDao();
        
        Servidor servidorRecuperado = instance.recuperarPorId(expectedCode);
        int code = servidorRecuperado.getCodigo();
        assertEquals(expectedCode, code);
        
    }

    /**
     * Test of recuperarTodos method, of class ServidorDao.
     */
    @Test
    public void testRecuperarTodos() throws Exception {
        System.out.println("recuperarTodos");
        ServidorDao instance = new ServidorDao();
        int expectedLength = 7;
        List<Servidor> result = instance.recuperarTodos();
        assertEquals(expectedLength, result.size());
        
    }
}