package br.com.open.eip.repository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import br.com.open.eip.beans.HealthService;

@Stateless(name="InfraHealthChecks")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InfraHealthChecksImpl implements InfraHealthChecks {
	
	
	@Inject private HealthService healthService; 

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public boolean isAlive() {
		return healthService.getAcesso() > 75 ? false : true;
	}


}
