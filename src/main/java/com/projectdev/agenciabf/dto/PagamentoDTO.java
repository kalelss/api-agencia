package com.projectdev.agenciabf.dto;

import java.util.Date;

import com.projectdev.agenciabf.entities.Pagamento;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class PagamentoDTO {

	@Temporal(TemporalType.DATE)
	private Date data;
	private Double valorVoo;
	private String cliente;
	
	public PagamentoDTO() {
	}
	
	public PagamentoDTO(Pagamento pagamento) {
		this.data = pagamento.getData();
		this.valorVoo = pagamento.getValorPagamento();
		this.cliente = pagamento.getCliente().getNome();
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValorVoo() {
		return valorVoo;
	}
	public void setValorVoo(Double valorVoo) {
		this.valorVoo = valorVoo;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
}
