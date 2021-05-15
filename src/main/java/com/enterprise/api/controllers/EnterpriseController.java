package com.enterprise.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.api.dtos.EnterpriseDto;
import com.enterprise.api.entities.Enterprise;
import com.enterprise.api.services.TakeEnterpriseService;

@RestController
@RequestMapping("api/empresa")
public class EnterpriseController {

	@Autowired
	TakeEnterpriseService takeEnterpriseService;

	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<EnterpriseDto> getEnterprise(@PathVariable("cnpj") long cnpj) {
		System.out.println(cnpj);

		Enterprise enterprise = takeEnterpriseService.getEnterprise(cnpj);
		EnterpriseDto enterpriseDto = new EnterpriseDto();
		if (enterprise == null)
			return null;

		enterpriseDto.setNomeFantasia(enterprise.getNomeFantasia());
		enterpriseDto.setRazaoSocial(enterprise.getRazaoSocial());
		return ResponseEntity.ok(enterpriseDto);
	}
}
