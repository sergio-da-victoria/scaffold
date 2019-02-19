package br.com.open.eip.endpoint;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import br.com.open.eip.entity.Produto;
import br.com.open.eip.repository.ProdutoRepository;


@Path("/produto")
public class ProdutoEndpoint {
	
   private static final Logger logger = Logger.getLogger(ProdutoEndpoint.class);

	@Inject private ProdutoRepository produtorepository;
	
	public ProdutoEndpoint() {
		logger.info("Incializando serviço web");
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consulta/id")
	public Response doConsulta(@QueryParam("seqproduto") Integer seqproduto) {
		Produto produto = produtorepository.bydIdProduto(seqproduto);
		return Response.ok(produto).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consulta/desc")
	public Response doConsulta(@QueryParam("desccompleta") String desccompleta) {
		Produto produto = produtorepository.byNameProduto(desccompleta);
		return Response.ok(produto).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consulta/all")
	public Response doConsulta( ) {
		List<Produto> produtos = produtorepository.allProduto();
		return Response.ok(produtos).build();
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/inclui")
	public Response doInclui(@Valid Produto produto) {
		produtorepository.create(produto);
		return Response.ok(produto).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/all")
	public Response doDeleteAll( ) {
		Boolean status = produtorepository.delete();
		return Response.ok(status).build();
	}

}
