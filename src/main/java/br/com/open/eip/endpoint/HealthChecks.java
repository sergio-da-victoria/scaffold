package br.com.open.eip.endpoint;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.wildfly.swarm.health.Health;
import org.wildfly.swarm.health.HealthStatus;

import br.com.open.eip.beans.HealthService;
import br.com.open.eip.repository.InfraHealthChecks;
import io.swagger.annotations.ApiOperation;

@Path("/infra")
public class HealthChecks {

	@Inject private InfraHealthChecks infraHealthChecksImpl;
	@Inject private HealthService healthService; 

    @GET
    @Path("/host")
    @Produces("text/plain")
    @ApiOperation("Retorna Host do balance")
    public String host() {
        String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
        return "Host [ "+hostname+ "] Acesso [ "+healthService.add() +"]"+" \n";
    }
	
    @GET
    @Path("/add")
    @Produces("text/plain")
    @ApiOperation("Adiciona Acesso")
    public void add() {
    	healthService.add();
    }
	        
	
	@GET
	@Health
	@Path("/health")
	public HealthStatus check() {
		if (infraHealthChecksImpl.isAlive()) {
			System.out.println("******************************************************* [ OK  ] "+healthService.getAcesso());
			return HealthStatus.named("service-state").up();
		} else {
			System.out.println("******************************************************* [ NOK ] "+healthService.getAcesso());
			return HealthStatus.named("service-state").down();
		}
	}


}
