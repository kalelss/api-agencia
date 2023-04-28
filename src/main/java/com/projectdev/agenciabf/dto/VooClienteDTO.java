package com.projectdev.agenciabf.dto;

import java.util.Date;

import com.projectdev.agenciabf.entities.Voo;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class VooClienteDTO {

	@Temporal(TemporalType.DATE)
	private Date data;
	private String origem;
	private String destino;
	private String carga;
	private Double valorVoo;
    private String nomePiloto;
    
	public VooClienteDTO(Voo voo) {
		this.data = voo.getData();
		this.origem = voo.getOrigem();
		this.destino = voo.getDestino();
		this.carga = voo.getCarga();
		this.valorVoo = voo.getValorVoo();
		this.nomePiloto = voo.getPiloto().getNome();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}

	public Double getValorVoo() {
		return valorVoo;
	}

	public void setValorVoo(Double valorVoo) {
		this.valorVoo = valorVoo;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}
}
