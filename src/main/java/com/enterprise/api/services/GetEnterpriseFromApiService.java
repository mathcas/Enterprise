package com.enterprise.api.services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.enterprise.api.controllers.exceptions.CNPJNotFoundException;
import com.enterprise.api.controllers.exceptions.TryAgainLaterException;
import com.enterprise.api.entities.Enterprise;

@Service
public class GetEnterpriseFromApiService {

	@Autowired
	RestTemplate restTemplate;

	public Enterprise getByCnpj(long cnpj) {
		try {
			String request = "https://www.receitaws.com.br/v1/cnpj/" + String.valueOf(cnpj);
			String response = restTemplate.getForObject(request, String.class);
			System.out.println(response);
			JSONObject jsonObj = new JSONObject(response);
			Enterprise enter = new Enterprise();
			enter.setNomeFantasia(jsonObj.get("fantasia").toString());
			enter.setRazaoSocial(jsonObj.get("nome").toString());
			return enter;
		} catch (JSONException e) {
			throw new CNPJNotFoundException("This CNPJ is invalid2");
		} catch (HttpClientErrorException e) {
			throw new TryAgainLaterException("Try again Later");
		}

	}
}
