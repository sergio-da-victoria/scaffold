package br.com.open.eip.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.util.SystemOutLogger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.open.eip.entity.Produto;
import br.com.open.eip.repository.ProdutoRepository;
import br.com.open.eip.test.deployments.DefaultDeployment;




@RunWith(Arquillian.class)
public class ProdutoRepositoryTest {
	
	
	
	@Deployment
    public static WebArchive deployment() throws URISyntaxException {
        return new DefaultDeployment( ).getArchive();
    }
	
	@Inject	private ProdutoRepository produtoRepository;
	private static final Integer _isOK = new Integer(1);

	@Test
	@InSequence(1)
	public void testAcessoEJB() {
		assertEquals(produtoRepository.IsOK(),_isOK);
	}

	@Test
	@InSequence(2)
	@UsingDataSet({"produtos.xml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testBuscaTodosProdutos() {
		List<Produto> produtos  =  produtoRepository.allProduto();
		assertEquals(3, produtos.size());
	}
	

	@Test
	@InSequence(3)
	public void testSalvarProduto() {
		Produto produto = new Produto();
		produto.setDesccompleta("Produto - Teste");
		produto.setQtdfabricadalote(new BigDecimal(1));
		produto.setDtahorinclusao(new java.util.Date());
		produto.setComplemento("Complemente -Teste");
		produto.setCodprodfiscal("F");
		produtoRepository.create(produto);
	}
	
	@Test
	@InSequence(4)
	@UsingDataSet({"produtos.xml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testBuscaDescricacao() {
		Produto produto =  produtoRepository.byNameProduto("desccompleta_1");
		assertEquals("desccompleta_1",produto.getDesccompleta());
	}

	
	
	@Test
	@InSequence(5)
	@UsingDataSet({"produtos.xml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testDeleteAll() {
		Boolean status =  produtoRepository.delete();
		assertEquals(Boolean.TRUE,status);
	}
	
	

	

}

