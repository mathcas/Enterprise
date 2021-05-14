package com.enterprise.api.dtos;

public class EnterpriseDto {
	private int cnpj;
	private String razaoSocial;
	private String fantasia;
	
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return fantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.fantasia = nomeFantasia;
	}
}
