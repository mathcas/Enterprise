package com.enterprise.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.api.entities.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
	
	Enterprise findByCnpj(long cnpj);

}
