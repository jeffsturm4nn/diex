/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.AreaConhecimento;
import model.negocio.AreaTematica;
import model.negocio.Curso;
import model.negocio.LinhaExtensao;
import model.negocio.LocalRealizacao;
import model.negocio.Servidor;
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
public class CursoDaoTest {
    
    public CursoDaoTest() {
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
     * Test of adicionar method, of class CursoDao.
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        
       ServidorDao servidorDao = new ServidorDao();
       Servidor servidor = servidorDao.recuperarPorId(5);
       
       AreaConhecimentoDao acd = new AreaConhecimentoDao();
       List<AreaConhecimento> areas = acd.recuperarTodos();
       AreaConhecimento area = areas.get(0);
       
       AreaTematicaDao atd = new AreaTematicaDao();
       List<AreaTematica> areastem = atd.recuperarTodos();
       AreaTematica areaT = areastem.get(0);
       
       LinhaExtensaoDao led = new LinhaExtensaoDao();
       List<LinhaExtensao> linhas = led.recuperarTodos();
       LinhaExtensao linha = linhas.get(0);
       
       LocalRealizacaoDao lrd = new LocalRealizacaoDao();
       List<LocalRealizacao> locais = lrd.recuperarTodos();
       LocalRealizacao local = locais.get(2);
       
       Curso curso = new Curso("Sencha Touch", "protocolo", "10/05/2013", "11/06/2013", "22/05/2013", servidor, 1);
        
       curso.setAreaConhecimento(area);
       curso.setAreaTematica(areaT);
       curso.setCargaHorariaSemanal("20 h");
       curso.setCargaHorariaTotal("80 h");
       curso.setHoraIni("8:00");
       curso.setHoraFim("11:00");
       curso.setLinhaExtensao(linha);
       curso.setLocalRealizacao(local);
       curso.setPublicoAlvo("estudantes");
       curso.setSituacao(1);
       curso.setDias("Segunda");
       curso.setProponente(servidor);
       
       CursoDao instance = new CursoDao();
       int expResult = 7;
       int result = instance.adicionar(curso);
       assertEquals(expResult, result);
        
    }

    /**
     * Test of alterar method, of class CursoDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        
        CursoDao instance = new CursoDao();
        Curso curso = instance.recuperarPorId(2);
        curso.setAvaliacaoResultados("resultados do curso: Os estudantes aduiriram conhecimentos.");
        
        boolean result = instance.alterar(curso);
        assertTrue(result);
        
    }

    /**
     * Test of remover method, of class CursoDao.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        int codigo = 3;
        CursoDao instance = new CursoDao();
        
        boolean result = instance.remover(codigo);
        assertTrue(result);
        
    }

    /**
     * Test of recuperarPorId method, of class CursoDao.
     */
    @Test
    public void testRecuperarPorId() throws Exception {
        System.out.println("recuperarPorId");
        int expectedCode = 2;
        CursoDao instance = new CursoDao();

        Curso result = instance.recuperarPorId(expectedCode);
        int code = result.getCodigo();
        assertEquals(expectedCode, code);
        
    }

    /**
     * Test of recuperarTodos method, of class CursoDao.
     */
    @Test
    public void testRecuperarTodos() throws Exception {
        System.out.println("recuperarTodos");
        CursoDao instance = new CursoDao();
        
        int expectedLength = 6;
        List<Curso> result = instance.recuperarTodos();
        assertEquals(expectedLength, result.size());
        
    }
}