package com.enterprise.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Enterprise implements Serializable {

	private static final long serialVersionUID = -7231518245688928534L;
	private Long id;
	private String nome;
	private long cnpj;
	private String fantasia;
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
		return nome;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.nome = razaoSocial;
	}

	@Column(name = "CNPJ", nullable = false)
	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "Nome_Fantasia", nullable = true)
	public String getNomeFantasia() {
		return fantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.fantasia = nomeFantasia;
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
