package com.enterprise.api.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.enterprise.api.entities.Enterprise;

@Service
public class GetEnterpriseFromApiService {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	public Enterprise getByCnpj(long cnpj) {
		String request = "https://www.receitaws.com.br/v1/cnpj/" + String.valueOf(cnpj);
		System.out.println(request);
		String response = restTemplate.getForObject(request , String.class);
		System.out.println(response);
		JSONObject jsonObj = new JSONObject(response);  
		Enterprise enter = new Enterprise();
		enter.setNomeFantasia(jsonObj.get("fantasia").toString());
		enter.setRazaoSocial(jsonObj.get("nome").toString());
		return enter;
	}
}
