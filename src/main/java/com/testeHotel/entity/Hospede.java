package com.testeHotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hospede {

	@Id
	@GeneratedValue( strategy= GenerationType.AUTO)
	private Long id;
	private String nome;
	private String documento;
	private String telefone;

	@OneToOne
	private CheckIn CheckIn;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public CheckIn getCheckIn() {
		return CheckIn;
	}
	public void setCheckIn(CheckIn checkIn) {
		CheckIn = checkIn;
	}
	
}
