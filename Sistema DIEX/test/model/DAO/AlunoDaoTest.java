/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.negocio.Aluno;
import model.negocio.Endereco;
import model.negocio.Escolaridade;
import model.negocio.Estado;
import model.negocio.PerfilCandidato;
import model.util.HibernateUtil;
import org.hibernate.Session;
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
public class AlunoDaoTest {
    
    
    
    public AlunoDaoTest() {
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
     * Test of adicionar method, of class AlunoDao.
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        
        PerfilCandidatoDao pcd = new PerfilCandidatoDao();
        List<PerfilCandidato> perfis = pcd.recuperarTodos();
        PerfilCandidato perfil = perfis.get(0);
        
        EscolaridadeDao ed = new EscolaridadeDao();
        List<Escolaridade> escolaridades = ed.recuperarTodos();
        Escolaridade escolaridade = escolaridades.get(0);
        
        EstadoDao estDao = new EstadoDao();
        List<Estado> estados = estDao.recuperarTodos();
        Estado estado = estados.get(0);
        
        Endereco end = new Endereco("Rua Olavo Bilac", "87", "Helióplis", "Garanhuns", estado, "55296-030");
        
        Aluno aluno = new Aluno("FABRICIO PAES FERREIRA", "M", "097.644.744-46", "8.631.991", "SDS", "01/11/1994", "fabricio@fabricio.com",
                 "Estudante", "(87)3761-1122", "(87)9656-1229", perfil, escolaridade, end, "Amigos", "29/06/2013");
        
        
        AlunoDao instance = new AlunoDao();
        int codigoAluno = 17;
        
        int result = instance.adicionar(aluno);
       
        
        assertEquals(codigoAluno, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class AlunoDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        
        AlunoDao instance = new AlunoDao();
        
        Aluno aluno = instance.recuperarPorId(9);
        aluno.setNome("Fabrício Paes Ferreira");
        
        boolean result = instance.alterar(aluno);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remover method, of class AlunoDao.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        
        int codigo = 1;
        
        AlunoDao instance = new AlunoDao();
        
        boolean result = instance.remover(codigo);
        
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of recuperarPorId method, of class AlunoDao.
     */
    @Test
    public void testRecuperarPorId() throws Exception {
        System.out.println("recuperarPorId");
        
        int codigoEsperado = 2;
        
        AlunoDao instance = new AlunoDao();
       
        Aluno alunoRecuperado = instance.recuperarPorId(codigoEsperado);
        int codigoRecuperado = alunoRecuperado.getCodigo();
        
        assertEquals(codigoEsperado, codigoRecuperado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of recuperarTodos method, of class AlunoDao.
     */
    @Test
    public void testRecuperarTodos() throws Exception {
        System.out.println("recuperarTodos");
        
        int tamanhoEsperado = 16;
        
        AlunoDao instance = new AlunoDao();
        
        List<Aluno> result = instance.recuperarTodos();
        
        assertEquals(tamanhoEsperado, result.size());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of recuperarPorCpf method, of class AlunoDao.
     */
    @Test
    public void testRecuperarPorCpf() {
        System.out.println("recuperarPorCpf");
        
        int codigoEsperado = 2;
        
        AlunoDao instance = new AlunoDao();
      
        Aluno alunoRecuperado = instance.recuperarPorCpf("111.111.111-11");
        int codigoRecuperado = alunoRecuperado.getCodigo();
        
        assertEquals(codigoEsperado, codigoRecuperado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}