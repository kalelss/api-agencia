package com.projectdev.agenciabf.dto;

import java.util.Date;

import com.projectdev.agenciabf.entities.Voo;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class VooPilotoDTO {
	
	@Temporal(TemporalType.DATE)
	private Date data;
	private String origem;
	private String destino;
	private Double comissaoPiloto;
	private String matriculaAviao;
    private String clienteNome;
    
	public VooPilotoDTO(Voo voo) {
		this.data = voo.getData();
		this.origem = voo.getOrigem();
		this.destino = voo.getDestino();
		this.comissaoPiloto = voo.getComissaoPiloto();
		this.matriculaAviao = voo.getMatriculaAviao();
		this.clienteNome = voo.getCliente().getNome();
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
	public Double getComissaoPiloto() {
		return comissaoPiloto;
	}
	public void setComissaoPiloto(Double comissaoPiloto) {
		this.comissaoPiloto = comissaoPiloto;
	}
	public String getMatriculaAviao() {
		return matriculaAviao;
	}
	public void setMatriculaAviao(String matriculaAviao) {
		this.matriculaAviao = matriculaAviao;
	}
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}
    
}
