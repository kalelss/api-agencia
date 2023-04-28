package com.projectdev.agenciabf.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb-voo")
public class Voo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date data;
	private String origem;
	private String destino;
	private String carga;
	private Double combustivel;
	private Double valorVoo;
	private Double comissaoPiloto;
	private String matriculaAviao;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;

    public Voo() {
    }
    
	public Voo(Date data, String origem, String destino, String carga, Double combustivel, Double valorVoo,
			Double comissaoPiloto, String matriculaAviao, Cliente cliente, Piloto piloto) {
		this.data = data;
		this.origem = origem;
		this.destino = destino;
		this.carga = carga;
		this.combustivel = combustivel;
		this.valorVoo = valorVoo;
		this.comissaoPiloto = comissaoPiloto;
		this.matriculaAviao = matriculaAviao;
		this.cliente = cliente;
		this.piloto = piloto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
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
}
