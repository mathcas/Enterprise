package com.enterprise.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.enterprise.api.entities.Enterprise;
import com.enterprise.api.repositories.EnterpriseRepository;

public class TakeEnterpriseServiceTest {

	@InjectMocks
	TakeEnterpriseService takeEnterpriseService;

	@Mock
	GetEnterpriseFromApiService getEnterpriseFromApiService;

	@Mock
	EnterpriseRepository enterpriseRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void givenHasAEnterpriseOnDB_WhenSearchthisByCnpj_ThenShouldReturnThisEnterprise() {
		// Given
		Enterprise enterprise = new Enterprise();
		enterprise.setCnpj(27865757000103L);
		enterprise.setRazaoSocial("Globo");
		enterprise.setNomeFantasia("Globinho");

		when(enterpriseRepository.findByCnpj(enterprise.getCnpj())).thenReturn(enterprise);

		// When
		Enterprise foundedEnterprise = takeEnterpriseService.getEnterprise(enterprise.getCnpj());

		// Then
		assertEquals(enterprise, foundedEnterprise);
		verify(enterpriseRepository, times(1)).findByCnpj(enterprise.getCnpj());
	}

	@Test
	public void givenNotHasAEnterpriseOnDB_WhenSearchthisByCnpj_ThenShouldTryFindOnApiAndReturnThisEnterprise() {
		// Given
		Enterprise enterprise = new Enterprise();
		enterprise.setCnpj(27865757000103L);
		enterprise.setRazaoSocial("Globo");
		enterprise.setNomeFantasia("Globinho");

		when(enterpriseRepository.findByCnpj(enterprise.getCnpj())).thenReturn(null);
		when(getEnterpriseFromApiService.getByCnpj(enterprise.getCnpj())).thenReturn(enterprise);
		when(enterpriseRepository.save(enterprise)).thenReturn(enterprise);
		// When
		Enterprise foundedEnterprise = takeEnterpriseService.getEnterprise(enterprise.getCnpj());

		// Then
		assertEquals(enterprise, foundedEnterprise);
		verify(enterpriseRepository, times(1)).findByCnpj(enterprise.getCnpj());
		verify(enterpriseRepository, times(1)).save(enterprise);
		verify(getEnterpriseFromApiService, times(1)).getByCnpj(enterprise.getCnpj());
	}
}
