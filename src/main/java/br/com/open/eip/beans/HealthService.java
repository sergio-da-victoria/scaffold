package br.com.open.eip.beans;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;


@Singleton(name="HealthService")
public class HealthService {

	private Long acesso = 0L;

	@PostConstruct
	public void init() {
		this.acesso = 0L;
	}

	public Long add() {
	    this.acesso=this.acesso+1L;
	    return this.acesso;
	}

	public Long getAcesso() {
		return this.acesso;
	}

	public void setAcesso(Long acesso) {
		this.acesso = acesso;
	}



}
