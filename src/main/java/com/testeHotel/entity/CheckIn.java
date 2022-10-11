package com.testeHotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

@Entity
public class CheckIn {
	
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO)
	private Long id;
	private Data dataEntrada;
	private Data dataSaida;
	private boolean adicionarVeiculo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Data getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Data dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Data getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Data dataSaida) {
		this.dataSaida = dataSaida;
	}
	public boolean isAdicionarVeiculo() {
		return adicionarVeiculo;
	}
	public void setAdicionarVeiculo(boolean adicionarVeiculo) {
		this.adicionarVeiculo = adicionarVeiculo;
	}
	
}
