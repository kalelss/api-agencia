package com.projectdev.agenciabf.dto;

import java.util.Date;

import com.projectdev.agenciabf.entities.Voo;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class VooDTO {

	@Temporal(TemporalType.DATE)
	private Date data;
	private String origem;
	private String destino;
	private String carga;
	private Double combustivel;
	private Double valorVoo;
	private String nomeCliente;
	private String nomePiloto;
	private String matriculaAviao;
	
	public VooDTO(Voo voo) {
		this.data = voo.getData();
		this.origem = voo.getOrigem();
		this.destino = voo.getDestino();
		this.carga = voo.getCarga();
		this.combustivel = voo.getCombustivel();
		this.valorVoo = voo.getValorVoo();
		this.nomeCliente = voo.getCliente().getNome();
		this.nomePiloto = voo.getPiloto().getNome();
		this.matriculaAviao = voo.getMatriculaAviao();
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

	public Double getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Double combustivel) {
		this.combustivel = combustivel;
	}

	public Double getValorVoo() {
		return valorVoo;
	}

	public void setValorVoo(Double valorVoo) {
		this.valorVoo = valorVoo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public String getMatriculaAviao() {
		return matriculaAviao;
	}

	public void setMatriculaAviao(String matriculaAviao) {
		this.matriculaAviao = matriculaAviao;
	}
}
