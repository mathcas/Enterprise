package com.enterprise.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "EMPRESA")
public class Enterprise implements Serializable {

	private static final long serialVersionUID = -7231518245688928534L;
	private Long id;
	private String razaoSocial;
	private int cnpj;
	private String nomeFantasia;
	private LocalDate createDate;
	private LocalDate updateDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Razao_Social", nullable = false)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(name = "CNPJ", nullable = false)
	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "Nome_Fantasia", nullable = true)
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	@PreUpdate
	public void preUpdate() {
		updateDate = LocalDate.now();
	}
	
	@PrePersist
	public void prePersist() {
		createDate = LocalDate.now();
		updateDate = LocalDate.now();
	}
}
