package br.com.open.eip.repository;

import javax.ejb.Local;

@Local
public interface InfraHealthChecks {
	public boolean isAlive();
}