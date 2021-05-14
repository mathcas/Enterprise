package com.enterprise.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.api.entities.Enterprise;
import com.enterprise.api.repositories.EnterpriseRepository;

@Service
public class TakeEnterpriseService {
	@Autowired
	GetEnterpriseFromApiService getEnterpriseFromApiService;

	@Autowired
	EnterpriseRepository enterpriseRepository;

	public Enterprise getEnterprise(long cnpj) {
		Enterprise enterprise = enterpriseRepository.findByCnpj(cnpj);
		if (enterprise == null) {
			enterprise = getEnterpriseFromApiService.getByCnpj(cnpj);
		}
		return enterprise;
	}
}
