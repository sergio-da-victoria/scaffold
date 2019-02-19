package br.com.open.eip.test;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import br.com.open.eip.entity.Produto;
import br.com.open.eip.test.deployments.DefaultDeployment;

@RunWith(Arquillian.class)
public class ProdutoEndpointTest {


    private static final int StatsOK = 200;
    private static final String FIND_PRODUTO_ID   = "http://127.0.0.1:8080/scaffold/produto/consulta/id?seqproduto=1";
    private static final String FIND_PRODUTO_DEC  = "http://127.0.0.1:8080/scaffold/produto/consulta/desc?desccompleta=desccompleta_1";
    private static final String FIND_PRODUTO_ALL  = "http://127.0.0.1:8080/scaffold/produto/consulta/all";
    private static final String INCLUI_PRODUTO    = "http://127.0.0.1:8080/scaffold/produto/inclui";
    private static final String DELETE_PRODUTO_ALL= "http://127.0.0.1:8080/scaffold/produto/delete/all";
    
   	private Client client = createClient();
	private WebTarget _target_inclui, _target_consulta_id,_target_consulta_desc,_target_consulta_all,_target_delete_all;

	@Before
	public void init() {
		this._target_consulta_id   = this.client.target(FIND_PRODUTO_ID);
		this._target_consulta_desc = this.client.target(FIND_PRODUTO_DEC);
		this._target_consulta_all  = this.client.target(FIND_PRODUTO_ALL);
		this._target_inclui        = this.client.target(INCLUI_PRODUTO);
		this._target_delete_all    = this.client.target(DELETE_PRODUTO_ALL);
   }

	@After
	public void down() throws Exception {
		this.client.close();
	}

	@Deployment
	public static WebArchive deployment() throws URISyntaxException {
        return new DefaultDeployment( ).getArchive();	
	}
	
	
	
	@Test
	@InSequence(1)
	@UsingDataSet({"produtos.xml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testConsultaProdutoID( ) throws JsonParseException, JsonMappingException, IOException	{
		Response response = this._target_consulta_id.request(MediaType.APPLICATION_JSON).get();
		assertEquals(StatsOK,response.getStatus());
		Produto produto = response.readEntity(Produto.class);
		assertEquals(produto.getDesccompleta(),produto.getDesccompleta());
	}
	
	
	@Test
	@InSequence(3)
	@UsingDataSet({"produtos.xml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testConsultaProdutoDesc( )	{
		Response response = this._target_consulta_desc.request(MediaType.APPLICATION_JSON).get();
		assertEquals(StatsOK,response.getStatus());
		Produto produto = response.readEntity(Produto.class);
		assertEquals(produto.getDesccompleta(),produto.getDesccompleta());
	}
	

	@Test
	@InSequence(3)
	@UsingDataSet({"produtos.xml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testConsultaProdutoAll( )	{
		Response response = this._target_consulta_all.request(MediaType.APPLICATION_JSON).get();
		assertEquals(StatsOK,response.getStatus());
		List<Produto> produtos = response.readEntity(new GenericType<List<Produto>>(){});
		assertEquals(3, produtos.size());
	}
	
		
	@Test
	@InSequence(4)
	public void testIncluiProduto( )	{
		Produto produto = new Produto();
		produto.setCodigoif(1);
		produto.setComplemento("complemento");
		produto.setDesccompleta("desccompleta");
		Response response = this._target_inclui
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(produto, MediaType.APPLICATION_XML), Response.class);

		assertEquals(StatsOK, response.getStatus());
	}
	
	
	@Test
	@InSequence(5)
	@UsingDataSet({"produtos.xml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testDeleteProduto( )	{
		Response response = this._target_delete_all.request(MediaType.APPLICATION_JSON).delete();
		assertEquals(StatsOK,response.getStatus());
		Boolean status = response.readEntity(Boolean.class);
		assertEquals(Boolean.TRUE,status);
	}
	
	
	
	Client createClient() {
		return ClientBuilder
				.newBuilder()
				.register(JacksonJaxbJsonProvider.class)
				.build();
	}


}
